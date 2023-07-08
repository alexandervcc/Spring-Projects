package acc.async.messaging.jmsbrokermessaging.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import acc.async.messaging.jmsbrokermessaging.model.Memo;

@Configuration
public class MessagingConfig {
  //Destination bean for injection in the send() method to the broker
  @Bean
  public Destination memoQueue() {
    return new ActiveMQQueue("localhost:61616");
  }

  @Bean
  public MappingJackson2MessageConverter messageConverter() {
    // Customize the message converter instead of using the default one
    MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
    messageConverter.setTypeIdPropertyName("_typeId");

    //Specify classname for the message to be converted on the receiver 
    Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
    typeIdMappings.put("memo", Memo.class);
    messageConverter.setTypeIdMappings(typeIdMappings);

    return messageConverter;
  }
}
