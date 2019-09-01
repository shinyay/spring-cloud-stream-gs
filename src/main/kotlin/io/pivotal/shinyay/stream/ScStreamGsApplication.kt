package io.pivotal.shinyay.stream

import io.pivotal.shinyay.stream.model.LogMessage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo

@SpringBootApplication
@EnableBinding(Processor::class)
class ScStreamGsApplication {

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	fun logMessage(log: LogMessage) = LogMessage("[1]: ${log.message}")
}

fun main(args: Array<String>) {
	runApplication<ScStreamGsApplication>(*args)
}
