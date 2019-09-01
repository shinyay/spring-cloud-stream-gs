package io.pivotal.shinyay.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScStreamGsApplication

fun main(args: Array<String>) {
	runApplication<ScStreamGsApplication>(*args)
}
