package acc.broker.rabbitmq.rabbitmq.services;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import acc.broker.rabbitmq.rabbitmq.model.Memo;
import acc.broker.rabbitmq.rabbitmq.services.interfaces.MemoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemoServiceImpl implements MemoService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMemo(Memo memo) {
        MessageConverter converter = rabbitTemplate.getMessageConverter();
        MessageProperties properties = new MessageProperties();
        properties.setHeader("MEMO_TYPE", "INFO");

        Message message = converter.toMessage(memo, properties);

        // 1th param = 'routing-key', => use default exchange
        this.rabbitTemplate.send("memo.info", message);
    }

    @Override
    public void convertAndSendMemo(Memo memo) {
        // Sending with the MessagePostprocessor
        this.rabbitTemplate.convertAndSend("memo.info", memo, message -> {
            MessageProperties properties = message.getMessageProperties();
            properties.setHeader("MEMO_TYPE", "INFO");
            return message;
        });

        // Uses the default of configured bean for MessageConvertor
        // this.rabbitTemplate.convertAndSend("memo.info", memo);
    }

}
