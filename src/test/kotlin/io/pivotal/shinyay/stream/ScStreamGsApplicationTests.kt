package io.pivotal.shinyay.stream

import io.pivotal.shinyay.stream.model.LogMessage
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import org.junit.Assert.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
@DirtiesContext
class ScStreamGsApplicationTests(val pipe: Processor,
								 val messageCollector: MessageCollector) {

	@Test
	fun whenSendMessage_thenResponseShouldUpdateText() {
		val message = MessageBuilder.withPayload(LogMessage("This is my message")).build()
		pipe.input().send(message)

		val payload = messageCollector.forChannel(pipe.output())
				.poll()
				.payload

		assertEquals("[1]: This is my message", payload.toString())
	}

}
