package es.fercbrt.springbootjparelationship.repositories;

import es.fercbrt.springbootjparelationship.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
}
