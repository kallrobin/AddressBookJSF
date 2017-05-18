package services;

import models.Contact;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class addContactService implements Serializable{
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    @Inject
    private AddressBookService service;

    public String addContact(){
        Contact contact = new Contact(firstName, lastName, address, phone);
        service.addContact(contact);
        FacesMessage msg = new FacesMessage("Success!", firstName + " " + lastName + " has been added to the address book");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "index.xhtml";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
