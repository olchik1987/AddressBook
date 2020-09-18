package com.olchik1987.service;

import com.olchik1987.contents.Address;
import com.olchik1987.contents.Contact;

import java.io.IOException;
import java.util.ArrayList;

import static com.olchik1987.util.Util.inputText;

public class ContactService {
    private StorageService storageService = new StorageService();

    public void createContact(String firstName, String lastName, long phoneNumber, Address address, String email) {
        Contact contact = new Contact(firstName, lastName, phoneNumber, address, email);

        saveContact(contact);
    }

    public void saveContact(Contact contact) {
        StorageService.saveContact(contact);
    }

    public Contact getContactByFirstName(String firstName) {
        return storageService.getByFirstName(firstName);
    }

    public ArrayList<Contact> getAllContacts() {
        return storageService.getAllContact();
    }

    /*  public void updateContact(Contact contact) {
          storageService.updateContact(contact);
      }*/

    public void deleteContact(Contact contact) {
        storageService.deleteContact(contact);
    }

    public void inputContact() throws IOException {

        System.out.println("Type your first name             ");
        String firstName = inputText();

        System.out.println("Type your last name         ");
        String lastName = inputText();

        System.out.println("Type your phone number  ");
        long phoneNumber = Long.parseLong(inputText());

        System.out.println("Address-------------------");
        System.out.println("House number      ");
        int houseNumber = Integer.parseInt(inputText());

        System.out.println("Street           ");
        String streetName = inputText();

        System.out.println("City           ");
        String cityName = inputText();

        System.out.println("State            ");
        String stateName = inputText();

        System.out.println("Zip code         ");
        int zipCode = Integer.parseInt(inputText());

        System.out.println("Email         ");
        String email = inputText();

        Contact contact = new Contact(firstName, lastName, phoneNumber, new Address(houseNumber, streetName, cityName, stateName, zipCode), email);

        saveContact(contact);
    }

    public void printContact(Contact contact) {
        System.out.println("=========================================================================================");
        System.out.println("First name                     " + contact.getFirstName());
        System.out.println("Last name                 " + contact.getLastName());
        System.out.println("Phone numer          " + contact.getPhoneNumber());
        System.out.println("Address ===================================================================================");
        System.out.println("House number              " + contact.getAddress().getHouseNumber());
        System.out.println("Street                   " + contact.getAddress().getStreetName());
        System.out.println("City                   " + contact.getAddress().getCity());
        System.out.println("State                    " + contact.getAddress().getState());
        System.out.println("Zip code                 " + contact.getAddress().getZipCode());
        System.out.println("Email          " + contact.getEmail());
        System.out.println("=========================================================================================");
    }

    public void printContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            if (contact != null) {
                printContact(contact);
            }
        }
    }

}
