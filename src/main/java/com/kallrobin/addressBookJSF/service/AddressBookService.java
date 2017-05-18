package com.kallrobin.addressBookJSF.service;

import com.kallrobin.addressBookJSF.fakeDB.FakeDB;
import com.kallrobin.addressBookJSF.models.Contact;

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

    public Contact getContact(long id) {
        return db.getContact(id);
    }

    public void deleteContact(long id){
        db.deleteContact(id);
    }
}
