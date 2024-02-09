
package ec.edu.espoch.clases;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Coseno extends IntegralTrigonometrica {
    public Mono<String> procesoCoseno(String v){
        return Mono.just("∫ "+v+" dx");
    }
    public Flux<String> integralCoseno(String v){
        separarValores(v);
        return resolverArgumento()
            .map(valo -> "Sen("+v+")/"+valo+" +c");
    }
    
}
