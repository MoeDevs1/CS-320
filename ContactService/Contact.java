package ContactService;

public class Contact {
    private String ID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String ID, String firstName, String lastName, String phone, String address) throws IllegalArgumentException {
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("ID must be less than 10");
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be less than 10");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be less than 30");
        }

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be less than 10");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be less than 10");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be a length of 10");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be less than 30");
        }
        this.address = address;
    }

    public String getID() {
        return this.ID;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }
}
