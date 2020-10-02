package com.olchik1987.util;

import com.olchik1987.contents.Address;
import com.olchik1987.service.ContactService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    private ContactService contactService = new ContactService();

    public void initApp() {

        Address testAddress1 = new Address(1, "TestStreet1", "TestCity1", "TestState1", 11111);
        Address testAddress2 = new Address(2, "TestStreet2", "TestCity2", "TestState2", 22222);
        Address testAddress3 = new Address(3, "TestStreet3", "TestCity3", "TestState3", 33333);

        contactService.createContact("TestName1", "TestLastName1", 1234567890L, testAddress1,"olga@gmail.com");
        contactService.createContact("TestName2", "TestLastName2", 2345678901L, testAddress2, "olga1@gmail.com");
        contactService.createContact("TestName3", "TestLastName3", 3456789012L, testAddress3, "olga3@gmail.com");
    }

    public static String inputText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }
}

