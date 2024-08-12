package es.fercbrt.springbootjparelationship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Course> courses;

    @Override
    public String toString() {
        return "Student {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", courses = " + courses +
                '}';
    }

}
