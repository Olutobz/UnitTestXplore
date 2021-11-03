import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsManagerTest {

    @Test
    public void shouldCreateContact() {
        ContactsManager contactsManager = new ContactsManager();
        contactsManager.addContact("Olutoba", "Onikoyi", "0123456789");
        Assertions.assertFalse(contactsManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactsManager.contactList.size());
        Assertions.assertTrue(contactsManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Olutoba")
                        && contact.getLastName().equals("Onikoyi")
                        && contact.getPhoneNumber().equals("0123456789")));

    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        ContactsManager contactsManager = new ContactsManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactsManager.addContact("Olutoba", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        ContactsManager contactsManager = new ContactsManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactsManager.addContact(null, "Onikoyi", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        ContactsManager contactsManager = new ContactsManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactsManager.addContact("Olutoba", "Onikoyi", null);
        });
    }

}