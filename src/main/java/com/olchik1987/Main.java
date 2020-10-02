package com.olchik1987;

import com.olchik1987.contents.Contact;
import com.olchik1987.service.ContactService;
import com.olchik1987.util.Util;

import java.io.IOException;

import static com.olchik1987.util.Util.inputText;


public class Main {

    private static ContactService contactService = new ContactService();
    private static Util util = new Util();

    public static void main(String[] args) throws IOException {

        util.initApp();

        System.out.println("=========================================================================================");
        System.out.println("                        Добро пожаловать в адресную книгу                                ");
        System.out.println("=========================================================================================");

        String command = "continue";

        while (!command.equals("exit")) {

            System.out.println("Подсказка по коммандам ==================================================================");
            System.out.println("enter contact           - ввод нового контакта ==========================================");
            System.out.println("print contacts          - вывод в консоль всех контактов ================================");
            System.out.println("search by name          - поиск по имени контакта =======================================");
            System.out.println("exit                    - выход =========================================================");
            System.out.println("=========================================================================================");
            System.out.println("Введите комманду");

            command = inputText();

            switch (command) {
                case "enter contact": {
                    contactService.inputContact();
                }
                break;
                case "print contacts": {
                    contactService.printContacts(contactService.getAllContacts());
                }
                break;
                case "search by name": {
                    System.out.println("Введите имя");
                    String name = inputText();
                    Contact contact = contactService.getContactByFirstName(name);

                    contactService.printContact(contact);
                }
                break;
                case "exit": {
                    command = "exit";
                }
                break;
                default: {
                    System.out.println("Вы ошиблись!!!");
                    command = "continue";
                }
            }

        }
    }
}