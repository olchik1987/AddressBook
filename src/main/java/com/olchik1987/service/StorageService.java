package com.olchik1987.service;

import com.olchik1987.contents.Contact;
import com.olchik1987.util.Sorter;
import com.olchik1987.util.Storage;

import java.util.ArrayList;

public class StorageService {

    public void saveContact(Contact contact) {

        Storage.getContacts().add(contact);
        Storage.getContacts().sort(new Sorter());
    }

    public ArrayList<Contact> getAllContact() {
        return Storage.getContacts();
    }

    public Contact getByFirstNameOrLastNameOrCityNameOrEmail(String searchQuery) {
        for (Contact contact : Storage.getContacts()) {

            if (contact.getFirstName().equals(searchQuery) || contact.getLastName().equals(searchQuery) || contact.getAddress().getCity().equals(searchQuery) || contact.getEmail().equals(searchQuery)) {
                return contact;
            }
        }

        return null;
    }

    public Contact getByFirstName(String firstName) {
        for (Contact contact : Storage.getContacts()) {

            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }

        return null;
    }

    public void removeContact(Contact contact) {
        Storage.getContacts().remove(contact);
    }
    public void removeAll() {
        Storage.getContacts().clear();
    }
}
