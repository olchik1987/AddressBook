package com.olchik1987.service;
import com.olchik1987.contents.Address;
import com.olchik1987.contents.Contact;
import com.olchik1987.util.Storage;

public class StorageService {

    public static void saveContact(Contact contact) {
        int emptySlotIndex = getFirstEmptySlotIndex();
        Storage.contacts[emptySlotIndex] = contact;
    }
    public Contact[] getAllContact() {
        return Storage.contacts;
    }

    public Contact getByFirstName(String firstName) {
        Contact contact = Storage.contacts[getContactIndexByFirstName(firstName)];
        return contact;
    }
    public Contact searchByLastName (String lastName){
        Contact contact = Storage.contacts[getContactIndexByLastName(lastName)];
        return contact;
    }

    public Contact searchByCityName( String city){
        Contact citySearch = Storage.contacts[getContactIndexByLastName(city)];
        return citySearch;
    }
    public void updateContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());
        Storage.contacts[index] = contact;
    }


    public void deleteContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());
        Storage.contacts[index] = null;
    }

    private static int getFirstEmptySlotIndex() {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] == null) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByFirstName(String firstName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i].getFirstName().equals(firstName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByLastName(String lastName){
        int index = 0;
        for (int i=0; i<Storage.contacts.length;i++){
            if (Storage.contacts[i].getLastName().equals(lastName)){
                index = i;
                break;
            }
        }
        return index;
    }

    private int getContactIndexByCity(String city){
        int index = 0;
        for (int i=0; i<Storage.contacts.length; i++){
            if(Storage.contacts[i].getCity().equals(city)){
                index = i;
                break;
            }
        }
        return index;
    }
}
