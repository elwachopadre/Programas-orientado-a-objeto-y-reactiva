
package ec.edu.espoch.clases;
import reactor.core.publisher.Flux;

public class IntegralTrigonometrica {
    private Flux<String> valoresSeparados;

    public void separarValores(String v){
        this.valoresSeparados = Flux.just(v)
            .map(val -> val.replace("Sen",""))
            .map(val -> val.replace("Cos",""))
            .map(val -> val.replace("Tan",""))
            .map(val -> val.replace("(",""))
            .map(val -> val.replace(")",""))
            .flatMap(val -> Flux.fromArray(val.split(" ")));
    }

    public void prueba(Flux<String> valoresSeparados){
        valoresSeparados.subscribe(System.out::println);
    }

    public Flux<String> resolverArgumento(){
        return this.valoresSeparados.map(terminos -> {
            double valorCoeficiente = 0;
            int valorExponente = 0;
            boolean valcanX = false;
            if (terminos.contains("x")) {
                valcanX = true;
                String xd = terminos.substring(0, terminos.indexOf("x"));
                if (xd.isEmpty() || xd.equals("+")) {
                    valorCoeficiente = 1;
                } else if (xd.equals("-")) {
                    valorCoeficiente = -1;
                } else {
                    valorCoeficiente = Double.parseDouble(xd);
                }
                if (terminos.contains("^")) {
                    String e = terminos.substring(terminos.indexOf("^") + 1);
                    valorExponente = Integer.parseInt(e);
                } else {
                    valorExponente = 1;
                }
            } else {
                valcanX = false;
                valorCoeficiente = Double.parseDouble(terminos);
                valorExponente = 0;
            }
            String resultadoProceso = "";
            if (valcanX & valorExponente != 1 & valorExponente != 2) {
                double nuevoExponente = valorExponente - 1;
                double nuevoCoeficiente = valorCoeficiente * valorExponente;
                String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                String nuevoExponenteString = String.valueOf(nuevoExponente);
                resultadoProceso = nuevoCoeficienteString + "x^" + nuevoExponenteString;
            } else if (valcanX & valorExponente == 2) {
                double nuevoCoeficiente = valorCoeficiente * valorExponente;
                String nuevoCoeficienteString = String.valueOf(nuevoCoeficiente);
                resultadoProceso = nuevoCoeficienteString + "x";
            } else if (valcanX & valorExponente == 1) {
                String nuevoCoeficienteString = String.valueOf(valorCoeficiente);
                resultadoProceso = nuevoCoeficienteString;
            } else {
                resultadoProceso = "";
            }
            return resultadoProceso;
        });
    }
    
}
