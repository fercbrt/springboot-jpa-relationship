package es.fercbrt.springbootjparelationship.repositories;

import es.fercbrt.springbootjparelationship.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
}
