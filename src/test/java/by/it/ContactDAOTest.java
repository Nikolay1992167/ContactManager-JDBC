package by.it;

import by.it.dao.ContactDAO;
import by.it.dao.ContactDAOImpl;
import by.it.entities.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDAOTest {
    private DriverManagerDataSource dataSource;
    private ContactDAO dao;

    @BeforeEach
    void setupBeforeEach(){
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
        int result = dao.save(contact);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void testUpdate() {
        Contact contact = new Contact(1, "Mikola", "steve@apple.com", "Stancia, Street", "763847682642");
        int result = dao.update(contact);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void testGet() {
        Integer id = 1;
        Contact contact = dao.getContact(id);
        if (contact != null){
            System.out.println(contact);
        }
        Assertions.assertNotNull(contact);
    }

    @Test
    void testDelete() {
        Integer id = 2;
        int result = dao.delete(id);
        Assertions.assertTrue(result>0);
    }

    @Test
    void testList() {
        List<Contact> contactList = dao.getContactsList();
        for (Contact contact: contactList){
            System.out.println(contact);
        }
        Assertions.assertTrue(!contactList.isEmpty());
    }
}
