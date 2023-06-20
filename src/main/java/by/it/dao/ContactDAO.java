package by.it.dao;

import by.it.entities.Contact;

import java.util.List;

public interface ContactDAO {
    int save(Contact contact);

    int update(Contact contact);

    Contact getContact(Integer id);

    int delete(Integer id);

    List<Contact> getContactsList();
}
