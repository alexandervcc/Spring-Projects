package acc.async.messaging.jmsbrokermessaging.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Memo implements Serializable {
  private String topic;
  private String message;
}
