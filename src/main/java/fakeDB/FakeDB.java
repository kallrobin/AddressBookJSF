package fakeDB;

import models.Contact;


import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Singleton
public class FakeDB {
    private Map<Long, Contact> contacts = new HashMap<>();
    private AtomicLong idInc = new AtomicLong();

    @PostConstruct
    public void init(){
        addContact(new Contact("John", "Doe", "1 Doestreet", "111-111-1111"));
        addContact(new Contact("Janet", "Doe", "1 Doestreet", "222-222-2222"));
        addContact(new Contact("James", "Doe", "1 Doestreet", "333-333-3333"));
    }

    public void addContact(Contact contact) {
        contact.setId(idInc.incrementAndGet());
        contacts.put(contact.getId(), contact);
    }

    public Contact deleteContact(long id){
        return contacts.remove(id);
    }

    public List<Contact> getAllContacts() {
        return contacts.values().stream().collect(Collectors.toList());
    }
}
