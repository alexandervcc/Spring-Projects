package acc.spring.jpa.jpapractice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.spring.jpa.jpapractice.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Long> {
    
    Page<Course> findByTitleContaining(String title, PageRequest pageRequest);
}
