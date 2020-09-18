package com.olchik1987.util;

import com.olchik1987.contents.Contact;

import java.util.ArrayList;

public class Storage {
    public static final int STORAGE_SIZE = 100;

    public static ArrayList<Contact> contacts = new ArrayList<>(STORAGE_SIZE);

    public static ArrayList<Contact> getContacts()
    {return contacts;};

}
