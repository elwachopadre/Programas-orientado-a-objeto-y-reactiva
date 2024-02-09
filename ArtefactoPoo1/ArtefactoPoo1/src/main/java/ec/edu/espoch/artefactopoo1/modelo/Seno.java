
package ec.edu.espoch.artefactopoo1.modelo;


public class Seno extends IntegralTrigonometrica {
    
    public String procesoSeno(){
        return "∫ "+getValor()+" dx";
    }
    
    public String integralSeno(){
        separarValores();
        return "- Cos("+getValo()+")/"+resolverArgumento()+" +c" ;
    }
    
}
