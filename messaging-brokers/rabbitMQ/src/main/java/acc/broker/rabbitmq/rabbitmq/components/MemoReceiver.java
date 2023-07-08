package acc.broker.rabbitmq.rabbitmq.components;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import acc.broker.rabbitmq.rabbitmq.model.Memo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class MemoReceiver {
    private final RabbitTemplate rabbit;
    private final MessageConverter converter;

    public void receiveMemo() {
        log.info("Retrieving message");
        //Receiving message from queue, it can be null if there is none
        //the timeout is configured as a property
        Message message = this.rabbit.receive("memo.queue");
        if (message == null) {
            log.info("Null received");
            return;
        }

        Memo memo = (Memo) converter.fromMessage(message);
        log.info(memo.toString());
    }
}
