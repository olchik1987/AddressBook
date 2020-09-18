package com.olchik1987.service;
import com.olchik1987.contents.Contact;
import com.olchik1987.util.Storage;

import java.util.ArrayList;

public class StorageService {

    public static void saveContact(Contact contact) {
        int emptySlotIndex = getFirstEmptySlotIndex();
        Storage.getContacts().add(contact);
    }
    public ArrayList<Contact> getAllContact() {
        return Storage.getContacts();
    }

    public Contact getByFirstName(String firstName) {
        Contact contact = Storage.contacts.get(getContactIndexByFirstName(firstName));
        return contact;
    }
    public Contact searchByLastName (String lastName){
        Contact contact = Storage.contacts.get(getContactIndexByLastName(lastName));
        return contact;
    }

    public Contact searchByCityName( String city){
        Contact citySearch = Storage.contacts.get(getContactIndexByLastName(city));
        return citySearch;
    }
    public void updateContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());
        Storage.contacts.set(index, contact);
    }


    public void deleteContact(Contact contact) {
        Storage.getContacts().remove(contact);
    }

    private static int getFirstEmptySlotIndex() {
        int index = 0;

        for (int i = 0; i <Storage.getContacts().length; i++) {
            if (Storage.contacts.get(i) == null) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByFirstName(String firstName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts.get(i).getFirstName().equals(firstName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByLastName(String lastName){
        int index = 0;
        for (int i=0; i<Storage.contacts.length;i++){
            if (Storage.contacts.get(i).getLastName().equals(lastName)){
                index = i;
                break;
            }
        }
        return index;
    }

    private int getContactIndexByCity(String city){
        int index = 0;
        for (int i=0; i<Storage.contacts.length; i++){
            if(Storage.contacts.get(i).getAddress().getCity().equals(city)){
                index = i;
                break;
            }
        }
        return index;
    }
}
