package com.olchik1987;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // Хранить контакты
        //Поиск контактов
        //Поиск по фамилии
        //Ввод фамилии
        //Вывод на экран

        Contact contact = new Contact("Olga");
        System.out.println(contact.getName());

        Address address = new Address();
        System.out.println(address.getCity());


        System.out.println('\n' + "Ввод данных для проекта AddressBook с консоли, пример");
        String firstName = enterText();
        String lastName = enterText();

        String[] names = new String[100];
        names[0] = firstName;
        names[1] = lastName;
        System.out.println("firstName = " + names[0]);
        System.out.println("lastName = " + names[1]);

    }

    private static String enterText() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст:");
        String name = reader.readLine();
        //System.out.println(name);
        return name;
    }
}