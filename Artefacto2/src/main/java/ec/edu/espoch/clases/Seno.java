
package ec.edu.espoch.clases;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Seno extends IntegralTrigonometrica {
    public Mono<String> procesoSeno(String v){
        return Mono.just("∫ "+v+" dx");
    }
    public Flux<String> integralSeno(String v){
        separarValores(v);
        return resolverArgumento()
            .map(valo -> "- Cos("+v+")/"+valo+" +c");
    
}
}
