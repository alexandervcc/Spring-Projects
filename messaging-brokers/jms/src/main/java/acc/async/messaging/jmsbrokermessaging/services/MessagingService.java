package acc.async.messaging.jmsbrokermessaging.services;

import acc.async.messaging.jmsbrokermessaging.model.Memo;

public interface MessagingService {
  public void sendMessage(Memo m);
  public void sendConvertedMessage(Memo m);
  public void sendConvertedMessageWithPostprocessing(Memo m);
  
}
