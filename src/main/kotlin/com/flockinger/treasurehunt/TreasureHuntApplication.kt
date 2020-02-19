package com.flockinger.treasurehunt

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication


@OpenAPIDefinition(
        info = Info(
                title = "Treasure Hunt",
                version = "0.0",
                description = "Get the gold!",
                license = License(name = "MIT", url = "http://flockinger.com")
        )
)
@SpringBootApplication
object TreasureHuntApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("mvkot.test")
                .mainClass(TreasureHuntApplication::class.java)
                .start()
    }
}