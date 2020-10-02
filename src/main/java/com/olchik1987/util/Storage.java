package com.olchik1987.util;

import com.olchik1987.contents.Contact;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

}
