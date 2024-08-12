package es.fercbrt.springbootjparelationship;

import es.fercbrt.springbootjparelationship.entities.*;
import es.fercbrt.springbootjparelationship.repositories.ClientRepository;
import es.fercbrt.springbootjparelationship.repositories.CourseRepository;
import es.fercbrt.springbootjparelationship.repositories.InvoiceRepository;
import es.fercbrt.springbootjparelationship.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        manyToOne();
        oneToMany();
        removeAddress();
        bidirectionalOneToMany();
        removeInvoiceBidirectional();
        manyToMany();
        removeManyToMany();
    }

    public void manyToOne() {
        Client client = clientRepository.findById(1L).orElse(null);

        client = checkClient(client);

        Invoice invoice = new Invoice(null, "Laptop purchase", 1000L, null);
        invoice.setClient(client);
        invoice = invoiceRepository.save(invoice);
        System.out.println(invoice);
    }

    public void oneToMany() {
        Client client = clientRepository.findById(1L).orElse(null);

        client = checkClient(client);

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

    public void bidirectionalOneToMany() {
        Client client = clientRepository.findById(1L).orElse(null);

        client = checkClient(client);

        List<Invoice> invoices = List.of(
                new Invoice(null, "Laptop purchase", 1000L, client),
                new Invoice(null, "Monitor purchase", 500L, client)
        );

        client.setInvoice(invoices);

        client = clientRepository.save(client);

        System.out.println(client);
    }

    private Client checkClient(Client client) {
        if (client == null) {
            client = new Client(null, "Fernando", "Calvino", null, null);
            client = clientRepository.save(client);
        }
        return client;
    }

    public void removeInvoiceBidirectional() {
        Client client = clientRepository.findById(1L).orElse(null);
        if (client != null) {
            client.getInvoice().remove(0);
            client = clientRepository.save(client);
            System.out.println(client);
        }
    }

    @Transactional
    public void manyToMany() {

        Student student1 = new Student(null, "Fernando", "Calvino", null);
        Student student2 = new Student(null, "John", "Doe", null);

        Course course1 = new Course(null, "Math");
        Course course2 = new Course(null, "History");

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course1));

        studentRepository.saveAll(Set.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);
    }

    @Transactional
    public void removeManyToMany() {
        Student student = studentRepository.findById(1L).orElse(null);
        if (student != null) {
            student.setCourses(null);
            studentRepository.save(student);
            System.out.println(student);
        }
    }
}
