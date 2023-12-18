package ContactService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "Mohannad", "Osman", "1234567890", "123 Main St");
        contactService.add(contact);

        Assertions.assertTrue(contactService.idExists("1"));
    }

    @Test
    public void testAddExistingContact() {
        Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Oak St");
        contactService.add(contact1);

        Contact contact2 = new Contact("2", "Updated", "Name", "1111111111", "789 Pine St");
        contactService.add(contact2);

        // The second addition should not change the existing contact
        Contact retrievedContact = contactService.list.get(0);
        Assertions.assertEquals("Jane", retrievedContact.getFirstName());
        Assertions.assertEquals("Doe", retrievedContact.getLastName());
        Assertions.assertEquals("9876543210", retrievedContact.getPhone());
        Assertions.assertEquals("456 Oak St", retrievedContact.getAddress());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("3", "Alice", "Smith", "1112223333", "789 Elm St");
        contactService.add(contact);

        contactService.delete("3");

        Assertions.assertFalse(contactService.idExists("3"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        contactService.delete("nonexistentID");

        // No contact should be deleted
        Assertions.assertEquals(0, contactService.list.size());
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("4", "Bob", "Johnson", "4445556666", "38434 father rd");
        contactService.add(contact);

        Contact updatedContact = new Contact("4", "Updated", "Name", "7778889999", "9349 houston St");
        contactService.update(updatedContact, "4");

        // The contact should be updated
        Contact retrievedContact = contactService.list.get(0);
        Assertions.assertEquals("Updated", retrievedContact.getFirstName());
        Assertions.assertEquals("Name", retrievedContact.getLastName());
        Assertions.assertEquals("7778889999", retrievedContact.getPhone());
        Assertions.assertEquals("123 macyes rd", retrievedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        Contact contact = new Contact("5", "Eve", "Miller", "5556667777", "456 candy St");

        // Attempting to update a nonexistent contact should have no effect
        contactService.update(contact, "nonexistentID");

        Assertions.assertEquals(0, contactService.list.size());
    }
}
