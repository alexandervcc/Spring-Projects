package acc.spring.jpa.jpapractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.spring.jpa.jpapractice.model.Teacher;

@Repository
public interface ITeacherRepository  extends JpaRepository<Teacher,Long>{
    
}
