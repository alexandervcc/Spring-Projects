package acc.broker.rabbitmq.rabbitmq.services.interfaces;

import acc.broker.rabbitmq.rabbitmq.model.Memo;

public interface MemoService {
    void sendMemo(Memo memo);

    void convertAndSendMemo(Memo memo);
}
