package com.flockinger.treasurehunt.api

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test

import javax.inject.Inject

@MicronautTest
class TreasureHuntingControllerTest {

    @Inject
    lateinit var huntingClient: HuntingClient

    @Test
    fun testGreetingService() {
        /* assertEquals(
                 "Hola, John!",
                 greetingClient.findTreasure("John").content
         ) */
    }
}
