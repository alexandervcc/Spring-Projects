package acc.spring.jpa.jpapractice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long teacherId;
    private String name;
    private String lastname;

    //One teacher for many courses
   /*  @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
        name="teacher_id",               //name for the fk column inside the db
        referencedColumnName = "teacherId"      //Pk of the present class
    )
    private List<Course> courses; */
}
