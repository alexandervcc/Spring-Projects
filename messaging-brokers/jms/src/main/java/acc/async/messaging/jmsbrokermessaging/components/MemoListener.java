package acc.async.messaging.jmsbrokermessaging.components;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import acc.async.messaging.jmsbrokermessaging.model.Memo;
import lombok.extern.slf4j.Slf4j;

import static acc.async.messaging.jmsbrokermessaging.constants.AppConstants.JMS_DESTINATION;

@Slf4j
@Component
public class MemoListener {
    @JmsListener(destination = JMS_DESTINATION)
    public void receiveMemo(Memo memo) {
        log.error("JMS_RESULT: " + memo.toString());
    }
}
