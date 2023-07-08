package acc.spring.jpa.jpapractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.spring.jpa.jpapractice.model.CourseMaterial;

@Repository
public interface ICourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
    
}
