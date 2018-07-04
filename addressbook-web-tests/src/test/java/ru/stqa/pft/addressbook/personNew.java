package ru.stqa.pft.addressbook;

public class personNew {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String companyName;
    private final String mobilePhone;
    private final String emailAddress;

    public personNew(String firstName, String middleName, String lastName, String companyName, String mobilePhone, String emailAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.mobilePhone = mobilePhone;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
