package ec.edu.espoch.artefactopoo1.controlador;

import ec.edu.espoch.artefactopoo1.modelo.Coseno;
import ec.edu.espoch.artefactopoo1.modelo.Seno;
import ec.edu.espoch.artefactopoo1.modelo.Tangente;
import ec.edu.espoch.artefactopoo1.vista.Interfaz;
public class Controlador {
    private Interfaz vista;
    private Coseno coseno;
    private Seno seno;
    private Tangente tan;

    public Controlador(Interfaz vista) {
        this.vista = vista;
        this.coseno = new Coseno();
        this.seno = new Seno();
        this.tan = new Tangente();
    }
    
    public void accionResolver(){
        long start = System.nanoTime();
        String funcion = String.valueOf(this.vista.getEntradaFuncion());
        
        if(funcion.contains("Sen")||funcion.contains("sen")) {
            this.seno.setValor(funcion);
            this.vista.mostrarResultado(this.seno.procesoSeno(), this.seno.integralSeno());
        }else if(funcion.contains("Cos")||funcion.contains("cos")){
            this.coseno.setValor(funcion);
            this.vista.mostrarResultado(this.coseno.procesoCoseno(), this.coseno.integralCoseno());  
        }else if(funcion.contains("Tan")||funcion.contains("tan")){
            this.tan.setValor(funcion);
            this.vista.mostrarResultado(this.tan.procesoTangente(), this.tan.integralTangente());
        }
        long finTiempo = System.nanoTime();
        long tiempoTotal = finTiempo - start;
        System.out.println("La operacion tomo "+ tiempoTotal + " microsegundos.");

    }
      

    }
    
    
    

