package com.kallrobin.addressBookJSF.pagebean;


import com.kallrobin.addressBookJSF.models.Contact;
import org.primefaces.event.RowEditEvent;
import com.kallrobin.addressBookJSF.service.AddressBookService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AddressBookBean implements Serializable{

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

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Contact edited", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit canceled", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void delete(Contact contact){
        if (contact != null){
            if (filteredContacts != null){
                filteredContacts.remove(contact);
            }
            contacts.remove(contact.getId());
            service.deleteContact(contact.getId());
            FacesMessage msg = new FacesMessage("Contact with id: " + contact.getId() + " deleted.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
