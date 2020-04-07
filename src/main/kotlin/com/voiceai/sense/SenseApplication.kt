package com.voiceai.sense

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class SenseApplication

fun main(args: Array<String>) {
    runApplication<SenseApplication>(*args)
}


@RestController
class RestController() {

    @GetMapping(value = ["/price/{symbol}"],
            produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun randomPrices(@PathVariable symbol: String): Flux<StorePrice> {
        return Flux.interval(Duration.ofSeconds(1))
                .doOnNext { println(symbol) }
                .map { StorePrice(symbol, randomPrice(), LocalDateTime.now()) }
    }

    private fun randomPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.0)

    }

}

data class StorePrice(var symbol: String,
                      var price: Double,
                      var time: LocalDateTime) {
}
