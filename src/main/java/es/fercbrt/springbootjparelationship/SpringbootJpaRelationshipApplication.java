package es.fercbrt.springbootjparelationship;

import es.fercbrt.springbootjparelationship.entities.Address;
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
        oneToMany();
        removeAddress();
    }

    public void manyToOne() {
        Client client = clientRepository.findById(1L).orElse(null);

        if (client == null) {
            client = new Client(null, "Fernando", "Calvino", null);
            client = clientRepository.save(client);
        }

        Invoice invoice = new Invoice(null, "Laptop purchase", 1000L, null);
        invoice.setClient(client);
        invoice = invoiceRepository.save(invoice);
        System.out.println(invoice);
    }

    public void oneToMany() {
        Client client = clientRepository.findById(1L).orElse(null);

        if (client == null) {
            client = new Client(null, "Fernando", "Calvino", null);
            client = clientRepository.save(client);
        }

        Address address1 = new Address(null, "Elmer St.", 1);
        Address address2 = new Address(null, "Elmer St.", 2);
        Address address3 = new Address(null, "Elmer St.", 3);

        client.getAddress().add(address1);
        client.getAddress().add(address2);
        client.getAddress().add(address3);

        client = clientRepository.save(client);
        System.out.println(client);
    }

    public void removeAddress () {
        Client client = clientRepository.findById(1L).orElse(null);
        if (client != null) {
            client.getAddress().remove(0);
            client = clientRepository.save(client);
            System.out.println(client);
        }
    }
}
