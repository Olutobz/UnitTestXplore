import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactsManagerTest {

    ContactsManager contactsManager;

    @BeforeAll
    public void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("Should be executed at the end of the test");
    }

    @BeforeEach
    public void setup() {
        contactsManager = new ContactsManager();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @Test
    public void shouldCreateContact() {
        contactsManager.addContact("Olutoba", "Onikoyi", "0123456789");
        assertFalse(contactsManager.getAllContacts().isEmpty());
        assertEquals(1, contactsManager.contactList.size());
        assertTrue(contactsManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Olutoba")
                        && contact.getLastName().equals("Onikoyi")
                        && contact.getPhoneNumber().equals("0123456789")));

    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        assertThrows(RuntimeException.class, () ->
                contactsManager.addContact("Olutoba", null, "0123456789"));
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        assertThrows(RuntimeException.class, () ->
                contactsManager.addContact(null, "Onikoyi", "0123456789")
        );
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        assertThrows(RuntimeException.class, () ->
                contactsManager.addContact("Olutoba", "Onikoyi", null));
    }

    @Test
    @DisplayName("Should Not Create Contact on Linux OS")
    @EnabledOnOs(value = OS.LINUX, disabledReason = "Disabled on Linux OS")
    public void shouldNotCreateContactOnlyOnLinux() {
        contactsManager.addContact("Olutoba", "Onikoyi", "0123456789");
        assertFalse(contactsManager.getAllContacts().isEmpty());
        assertEquals(1, contactsManager.contactList.size());
        assertTrue(contactsManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Olutoba")
                        && contact.getLastName().equals("Onikoyi")
                        && contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Should Create Contact Only on MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MAC OS")
    public void shouldCreateContactOnlyOnMac() {
        contactsManager.addContact("Olutoba", "Onikoyi", "0123456789");

        assertFalse(contactsManager.getAllContacts().isEmpty());
        assertEquals(1, contactsManager.contactList.size());
        assertTrue(contactsManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Olutoba")
                        && contact.getLastName().equals("Onikoyi")
                        && contact.getPhoneNumber().equals("0123456789")));
    }

    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5)
    public void shouldTestContactCreationRepeatedly() {
        contactsManager.addContact("Olutoba", "Onikoyi", "0123456789");
        assertFalse(contactsManager.getAllContacts().isEmpty());
        assertEquals(1, contactsManager.contactList.size());
    }

}