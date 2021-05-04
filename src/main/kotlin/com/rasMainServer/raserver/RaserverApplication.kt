package com.rasMainServer.raserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RaserverApplication

fun main(args: Array<String>) {
	runApplication<RaserverApplication>(*args)
}
