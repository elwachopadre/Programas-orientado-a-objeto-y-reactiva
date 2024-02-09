
package ec.edu.espoch.clases;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Tangente extends IntegralTrigonometrica {
    public Mono<String> procesoTangente(String v){
        return Mono.just("∫ "+v+" dx");
    }
    public Flux<String> integralTangente(String v){
        separarValores(v);
        return resolverArgumento()
            .map(valo -> "In(Sec("+v+"))/"+valo+" +c");
    }
    
}
