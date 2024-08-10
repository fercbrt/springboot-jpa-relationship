package es.fercbrt.springbootjparelationship.repositories;

import es.fercbrt.springbootjparelationship.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
}
