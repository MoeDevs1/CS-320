package ContactService;

import java.util.ArrayList;

public class ContactService {
    ArrayList<Contact> list = new ArrayList<Contact>();

    public ContactService() {}

    public void add(Contact contact) {
        if (idExists(contact.getID())) {
            System.out.println("ContactService.ContactService.Contact exists");
        } else {
            list.add(contact);
        }
    }

    public void delete(String id) {
        if (!idExists(id)) {
            System.out.println("ContactService.ContactService.Contact does not exist");
        } else {
            Contact contactToRemove = null;
            for (Contact contact : list) {
                if (contact.getID().equals(id)) {
                    contactToRemove = contact;
                    break;
                }
            }
            if (contactToRemove != null) {
                list.remove(contactToRemove);
                System.out.println("ContactService.ContactService.Contact deleted");
            }
        }
    }

    public void update(Contact contact, String id) {
        if (idExists(id)) {
            // Find the existing contact and update its details
            for (Contact existingContact : list) {
                if (existingContact.getID().equals(id)) {
                    existingContact.setFirstName(contact.getFirstName());
                    existingContact.setLastName(contact.getLastName());
                    existingContact.setPhone(contact.getPhone());
                    existingContact.setAddress(contact.getAddress());
                    System.out.println("ContactService.ContactService.Contact updated");
                    break;
                }
            }
        } else {
            System.out.println("ContactService.ContactService.Contact does not exist");
        }
    }

    boolean idExists(String id) {
        for (Contact contact : list) {
            if (contact.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
