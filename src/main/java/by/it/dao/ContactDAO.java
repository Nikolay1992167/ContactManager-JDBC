package by.it.dao;

import by.it.entities.Contact;

import java.util.List;

public interface ContactDAO {
    void saveOrUpdate(Contact contact);

    void delete(int contactId);

    Contact get(int contactId);

    List<Contact> list();
}
