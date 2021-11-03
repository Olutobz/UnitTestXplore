import org.junit.jupiter.api.*;

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
        Assertions.assertThrows(RuntimeException.class, () ->
                contactsManager.addContact("Olutoba", null, "0123456789"));
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () ->
                contactsManager.addContact(null, "Onikoyi", "0123456789")
        );
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException.class, () ->
                contactsManager.addContact("Olutoba", "Onikoyi", null));
    }

}