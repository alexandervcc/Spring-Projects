package acc.spring.jpa.jpapractice.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import acc.spring.jpa.jpapractice.model.Course;

@SpringBootTest
public class ICourseRepositoryTest {
    @Autowired
    ICourseRepository courseRepository;

    @Test
    public void testPagination() {
        Pageable firstPageThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageThreeRecords).getContent();
        Long elements = courseRepository.findAll(firstPageThreeRecords).getTotalElements();
        Integer pages = courseRepository.findAll(firstPageThreeRecords).getTotalPages();

        System.out.println("Courses Gotten: "+courses.size());
        System.out.println("Elements: "+elements);
        System.out.println("Pages: "+pages);
        
    }
}
