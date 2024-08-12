package es.fercbrt.springbootjparelationship;

import es.fercbrt.springbootjparelationship.entities.Client;
import es.fercbrt.springbootjparelationship.entities.Invoice;
import es.fercbrt.springbootjparelationship.repositories.ClientRepository;
import es.fercbrt.springbootjparelationship.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        manyToOne();
    }

    public void manyToOne() {
        Client client = new Client(null,"Fernando", "Calvino");
        client = clientRepository.save(client);

        Invoice invoice = new Invoice(null, "Laptop purchase", 1000L, null);
        invoice.setClient(client);
        invoice = invoiceRepository.save(invoice);
        System.out.println(invoice);
    }
}
