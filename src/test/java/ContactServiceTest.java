import com.olchik1987.contents.Address;
import com.olchik1987.contents.Contact;
import com.olchik1987.service.ContactService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactServiceTest {

    private static ContactService contactService;
    private static Address address;
    private static String firstName;
    private static String lastName;
    private static long phoneNumber;
    private static String email;
    private static Contact contact;

    @BeforeAll
    public static void setUp() {
        contactService = new ContactService();
        firstName = "Olga";
        lastName = "Lytvynova";
        phoneNumber = 123456789;
        email = "olga@gmail.com";
        int houseNumber = 12;
        String streetName = "myStreet";
        String city = "Harrisburg";
        String state = "PA";
        int zipCode = 11111;

        address = new Address(houseNumber, streetName, city, state, zipCode);
        contact = new Contact(firstName, lastName, phoneNumber, address, email);
    }

    @Test
    public void createContactContactShouldBeCreated() {
        contactService.createContact(firstName, lastName, phoneNumber, address, email);

        assertNotNull(contactService.searchByFirstNameOrLastNameOrCityNameOrEmail(firstName));
    }

    @Test
    public void createContactThrowExceptionWhenAddressIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(firstName, lastName, phoneNumber, null, email);
        });
    }

    @Test
    public void createContactThrowExceptionWhenFirstNameIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(null, lastName, phoneNumber, address, email);
        });
    }

    @Test
    public void createContactThrowExceptionWhenLastNameIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(firstName, null, phoneNumber, address, email);
        });
    }

    @Test
    public void createContactThrowExceptionWhenEmailIsNull() {

        assertThrows(NullPointerException.class, () -> {
            contactService.createContact(firstName, lastName, phoneNumber, address, null);
        });
    }

    @Test
    public void saveContactContactShouldGetSaved() {
        contactService.saveContact(contact);

        assertNotNull(contactService.searchByFirstNameOrLastNameOrCityNameOrEmail(firstName));
    }

    @Test
    public void getContactByFirstNameShouldDisplayContact() {
        String firstName = contact.getFirstName();
        contactService.saveContact(contact);

        assertEquals(firstName, contactService.getContactByFirstName(firstName).getFirstName());
    }

    @Test
    public void deleteContactByFirstNameContactShouldGetDeleted() {
        contactService.createContact(firstName, lastName, phoneNumber, address, email);
        contactService.deleteContactByFirstName(firstName);

        assertTrue(contactService.getAllContacts().isEmpty());
    }

    @Test
    public void deleteAllAllContactsShouldGetDeleted() {
        contactService.createContact(firstName, lastName, phoneNumber, address, email);
        contactService.deleteContact(contactService.getContactByFirstName(firstName));

        assertTrue(contactService.getAllContacts().isEmpty());
    }
    /*public void printContactsDisplaysAllContacts() {
        contactService.createContact(firstName, lastName, phoneNumber, address, email);
        ? assertTrue();*/

    @AfterEach
    void tearDown() {
        contactService.deleteAll();
    }

}
