package services;

import fakeDB.FakeDB;
import models.Contact;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class AddressBookService {

    @Inject
    private FakeDB db;

    public List<Contact> getContacts(){
        return db.getAllContacts();
    }

    public void addContact(Contact contact){
        db.addContact(contact);
    }

    public void deleteContact(long id){
        db.deleteContact(id);
    }
}
