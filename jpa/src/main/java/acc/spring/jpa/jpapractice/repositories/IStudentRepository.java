package acc.spring.jpa.jpapractice.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import acc.spring.jpa.jpapractice.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    // Query creation with Spring Dialect languaje
    public List<Student> findByName(String name);

    public List<Student> findByNameContaining(String name);

    public List<Student> findByGuardianName(String guardianname);

    public Student findByNameAndLastname(String name, String lastname);

    // For customed Query annotation, use the Class atribute name, not the table nor
    // column name
    @Query(value = "select s from Student s where s.email = ?1")
    List<Student> getStudentByEmailAddress(String email);

    // NATIVE QUERY
    @Query(value = "Select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String email);

    // QUERY WITH NAMED PARAMS
    @Query(value = "Select * from tbl_student s where s.email_address = :emailXD", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailXD") String email);

    //MODIFYING & TRANSACTIONAL
    @Modifying
    @Transactional
    @Query(
        value = "update tbl_student set name=?1 where email_address=>2",
        nativeQuery = true
    )    
    int updateStudentNameByEmail(String name, String email);
}
