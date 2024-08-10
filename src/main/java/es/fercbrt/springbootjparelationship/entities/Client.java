package es.fercbrt.springbootjparelationship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    @Override
    public String toString() {
        return "Client {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", lastname = '" + lastname + '\'' +
                '}';
    }
}
