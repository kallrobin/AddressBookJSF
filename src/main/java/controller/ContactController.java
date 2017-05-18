package controller;


import models.Contact;
import services.ContactService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ContactController implements Serializable{

    private List<Contact> contacts;

    @Inject
    private ContactService contactService;

    @PostConstruct
    private void init(){
        contacts = contactService.getContacts();
    }

    private Contact selectedContact = new Contact("","","", 0);



    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact getContact() {
        return selectedContact;
    }

    public void setContact(Contact contact) {
        contactService.setContact(contact);
    }

    public String getFirstName() {
        return selectedContact.getFirstName();
    }

    public void setFirstName(String firstName) {
        selectedContact.setFirstName(firstName);
    }

    public String getLastName() {
        return selectedContact.getLastName();
    }

    public void setLastName(String lastName) {
        selectedContact.setLastName(lastName);
    }

    public String getAddress() {
        return selectedContact.getAddress();
    }

    public void setAddress(String address) {
        selectedContact.setAddress(address);
    }

    public int getPhone() {
        return selectedContact.getPhone();
    }

    public void setPhone(int phone) {
        selectedContact.setPhone(phone);
    }
}
