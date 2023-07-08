package acc.spring.jpa.jpapractice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;

    private String url;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY          //Retrieve inmediatly or later the data of the related table
    )
    @JoinColumn(
        name = "fk_course_id",                  //name for column inside the db
        referencedColumnName = "courseId"       //column name of the reference table 
    )
    private Course course;

}
