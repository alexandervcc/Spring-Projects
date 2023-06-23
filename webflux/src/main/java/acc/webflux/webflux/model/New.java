package acc.webflux.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@Document
@AllArgsConstructor
@NoArgsConstructor
public class New {
    @Id
    private  String id;

    private String title;

    private String description;

    private String content;

    @DBRef
    private Author author;
}
