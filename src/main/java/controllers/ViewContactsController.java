package controllers;


import models.Contact;
import services.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ViewContactsController implements Serializable{

    private List<Contact> contacts;
    private List<Contact> filteredContacts;

    @Inject
    private AddressBookService service;

    @PostConstruct
    private void init(){
        contacts = service.getContacts();
    }

    public List<Contact> getContacts(){
        return contacts;
    }

    public List<Contact> getFilteredContacts(){
        return filteredContacts;
    }

    public void setFilteredContacts(List<Contact> filteredContacts){
        this.filteredContacts = filteredContacts;
    }



    public void delete(Contact contact){
        if (contact != null){
            if (filteredContacts != null){
                filteredContacts.remove(contact);
            }
            contacts.remove(contact.getId());
            service.deleteContact(contact.getId());
        }
    }
}
