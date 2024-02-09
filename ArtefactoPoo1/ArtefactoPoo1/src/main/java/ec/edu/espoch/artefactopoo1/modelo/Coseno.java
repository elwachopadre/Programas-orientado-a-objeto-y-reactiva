package ec.edu.espoch.artefactopoo1.modelo;

public class Coseno extends IntegralTrigonometrica {
    
    public String procesoCoseno(){
        return "∫ "+getValor()+" dx";
    }
    
    public String integralCoseno(){
        separarValores();
        return "Sen("+getValo()+")/"+resolverArgumento()+" +c" ;
    }
}
