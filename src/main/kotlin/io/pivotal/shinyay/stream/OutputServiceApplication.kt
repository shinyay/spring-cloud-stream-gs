package io.pivotal.shinyay.stream

import io.pivotal.shinyay.stream.processor.ProcessorInterface
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.support.MessageBuilder

@SpringBootApplication
@EnableBinding(ProcessorInterface::class)
class OutputServiceApplication(val processor: ProcessorInterface) {

    @StreamListener()
    fun routeValue(value: Int) {
        if (value < 10) {
            processor.output()
                    .send(MessageBuilder.withPayload(value).build())
        } else {
            processor.otherOutput()
                    .send(MessageBuilder.withPayload(value).build())
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ScStreamGsApplication>(*args)
}
