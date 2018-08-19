package ru.stqa.pft.addressbook.modelGroup;

import java.util.Objects;

public class UserData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    //private String middleName;
    private String lastName;
    //private String companyName;
    //private String mobilePhone;
    //private String emailAddress;
    private String group;

    @Override
    public String toString() {
        return "UserData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }
    //public String getMiddleName() {return middleName;}
    public String getLastName() {
        return lastName;
    }
    //public String getCompanyName() {return companyName;}
    //public String getMobilePhone() {return mobilePhone;}
    //public String getEmailAddress() {return emailAddress;}
    public String getGroup() { return group; }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData that = (UserData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }
    public UserData withName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserData withGroup(String group) {
        this.group = group;
        return this;
    }

}


