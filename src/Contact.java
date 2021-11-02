public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void validateFirstName() {
        if (this.firstName.isBlank())
            throw new RuntimeException("First Name Cannot Be Null Or Empty");
    }

    public void validateLastName() {
        if (this.lastName.isBlank())
            throw new RuntimeException("Last Name Cannot Be Null Or Empty");
    }

    public void validatePhoneNumber() {
        if (this.phoneNumber.isBlank()) {
            throw new RuntimeException("Phone Number Cannot Be Null Or Empty");
        }

        if (this.phoneNumber.length() != 10) {
            throw new RuntimeException("Phone Number Should Be 10 Digits Long");
        }

        if (!this.phoneNumber.startsWith("0")) {
            throw new RuntimeException("Phone Number Should Start With 0");
        }

        if (!this.phoneNumber.matches("\\d+")) {
            throw new RuntimeException("Phone Number Should Contain Only Digits");
        }
    }

}
