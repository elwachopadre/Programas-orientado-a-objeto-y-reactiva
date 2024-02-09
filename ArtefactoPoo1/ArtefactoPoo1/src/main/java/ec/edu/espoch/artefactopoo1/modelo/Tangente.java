package ec.edu.espoch.artefactopoo1.modelo;

public class Tangente extends IntegralTrigonometrica {
    
    public String procesoTangente(){
        return "∫ "+getValor()+" dx";
    }
    
    public String integralTangente(){
        separarValores();
        return "In(Sec("+getValo()+"))/"+resolverArgumento()+" +c" ;
    }  
}
