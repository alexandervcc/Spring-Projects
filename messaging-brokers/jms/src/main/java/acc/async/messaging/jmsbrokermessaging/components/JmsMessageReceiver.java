package acc.async.messaging.jmsbrokermessaging.components;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import acc.async.messaging.jmsbrokermessaging.model.Memo;
import lombok.AllArgsConstructor;

import static acc.async.messaging.jmsbrokermessaging.constants.AppConstants.JMS_DESTINATION;

@Component
@AllArgsConstructor
public class JmsMessageReceiver {
    private JmsTemplate jmsTemplate;
    private MessageConverter converter;

    public Memo receiveMemo() throws JMSException {
        Message message = this.jmsTemplate.receive(JMS_DESTINATION);
        return (Memo) converter.fromMessage(message);
    }

    public Memo receiveAndConvertMemo() throws JMSException {
        return (Memo) this.jmsTemplate.receiveAndConvert(JMS_DESTINATION);
    }
}
