package by.it;

import by.it.dao.ContactDAO;
import by.it.dao.ContactDAOImpl;
import by.it.entities.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class ContactDAOTest {
    private DriverManagerDataSource dataSource;
    @Autowired
    private ContactDAO dao;

    @BeforeEach
    void setupBeforeEach() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/first_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("87654321");

        dao = new ContactDAOImpl(dataSource);
    }

    @Test
    void testSave() {
        Contact contact = new Contact("Steve Jobs", "steve@apple.com", "Cupertino, CA", "763847682642");
        dao.saveOrUpdate(contact);
        Assertions.assertTrue(contact.getId() > 0);
    }

    @Test
    void testUpdate() {
        Contact contact = new Contact(1, "Mikola", "steve@apple.com", "Stancia, Street", "763847682642");
        dao.saveOrUpdate(contact);
        String phone = "763847682642";
        Assertions.assertEquals(phone, contact.getTelephone());
    }

    @Test
    void testGet() {
        int id = 1;
        Contact contact = dao.get(id);
        Assertions.assertNotNull(contact);
    }

    @Test
    void testDelete() {
        Integer id = 2;
        dao.delete(id);
        Assertions.assertNull(dao.get(id));
    }

    @Test
    void testList() {
        List<Contact> contactList = dao.list();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
        Assertions.assertFalse(contactList.isEmpty());
    }
}
