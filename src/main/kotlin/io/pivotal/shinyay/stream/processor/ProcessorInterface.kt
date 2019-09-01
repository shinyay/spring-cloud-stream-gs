package io.pivotal.shinyay.stream.processor

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface ProcessorInterface {

    val INPUT: String

    @Input
    fun input(): SubscribableChannel

    @Output("myOutput")
    fun output(): MessageChannel

    @Output
    fun otherOutput(): MessageChannel
}