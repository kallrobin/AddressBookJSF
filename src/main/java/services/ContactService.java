package services;

import models.Contact;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ContactService {
    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    public ContactService() {
        setContact(new Contact("Pelle", "Potatis", "Hemma", 07373737));
        setContact(new Contact("Erik", "andarin", "Borta", 07373737));
        setContact(new Contact("Sven", "Potatis", "Jobbet", 07373737));
        setContact(new Contact("Karl", "Klåpare", "Krogen", 07373737));
    }


    public void setContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    public Contact getContact(String id){
        return contacts.get(id);
    }

    public List<Contact> getContacts() {
        return contacts.values().stream().collect(Collectors.toList());
    }
}
