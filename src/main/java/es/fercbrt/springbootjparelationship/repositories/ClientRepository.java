package es.fercbrt.springbootjparelationship.repositories;

import es.fercbrt.springbootjparelationship.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
