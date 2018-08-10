package ru.stqa.pft.addressbook.modelGroup;

import java.util.Objects;

public class PersonData {
    private final String firstName;
    //private final String middleName;
    private final String lastName;
    private final String companyName;
    //private final String mobilePhone;
    //private final String emailAddress;
    private String group;

    public PersonData(String firstName, String lastName, String group, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        //this.mobilePhone = mobilePhone;
        //this.emailAddress = emailAddress;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    //public String getMiddleName() {return middleName;}

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    //public String getMobilePhone() {return mobilePhone;}

    //public String getEmailAddress() {return emailAddress;}

    public String getGroup() { return group; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData that = (PersonData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


