package com.olchik1987.service;

import com.olchik1987.contents.Contact;
import com.olchik1987.util.Storage;

import java.util.ArrayList;

public class StorageService {

    public static void saveContact(Contact contact) {
        Storage.getContacts().add(contact);
    }

    public ArrayList<Contact> getAllContact() {
        return Storage.getContacts();
    }

    public Contact getByFirstName(String firstName) {

        for (Contact contact : Storage.getContacts()) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }

        return null;
    }

    public Contact searchByLastName(String lastName) {
        for (Contact contact : Storage.getContacts()) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }

        return null;
    }

    public Contact searchByCityName(String city) {
        for (Contact contact : Storage.getContacts()) {
            if (contact.getAddress().getCity().equals(city)) {
                return contact;
            }
        }

        return null;
    }

/*    public void updateContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());
        Storage.getContacts().set(index, contact);
    }*/

    public void deleteContact(Contact contact) {
        Storage.getContacts().remove(contact);
    }

}
