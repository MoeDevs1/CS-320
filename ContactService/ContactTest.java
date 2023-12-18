package ContactService;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C12345", "Moe", "Okans", "5551234567", "84 Manchester St");
        assertEquals("C12345", contact.getID());
        assertEquals("Moe", contact.getFirstName());
        assertEquals("Okans", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("84 Manchester St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Smith", "Robues", "5551234567", "84 Manchester St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C12345678901", "Hatim", "OSman", "5551234567", "84 Manchester St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C12345", null, "Lola", "5551234567", "84 Manchester St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C12345", "Parker", "Smith", "5551234567", null);
        });
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("C12345", "Handy", "slob", "5551234567", "84 Manchester St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("NameThatIsTooLong");
        });
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("C12345", "John", "Smith", "5551234567", "84 Manchester St");
        contact.setLastName("Johnson");
        assertEquals("Johnson", contact.getLastName());

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("NameThatIsTooLong");
        });
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("C12345", "John", "Smith", "5551234567", "84 Manchester St");
        contact.setPhone("5559876543");
        assertEquals("5559876543", contact.getPhone());

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("C12345", "Loly", "Ingo", "5551234567", "84 Manchester St");
        contact.setAddress("Hulp froster St");
        assertEquals("Hulp froster St", contact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("AddressThatIsTooLong123456789012345678901234567890");
        });
    }
}
