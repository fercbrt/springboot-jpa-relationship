package es.fercbrt.springbootjparelationship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @Override
    public String toString() {
        return "Address {" +
                "id = " + id +
                ", street = '" + street + '\'' +
                ", number = " + number +
                '}';
    }
}
