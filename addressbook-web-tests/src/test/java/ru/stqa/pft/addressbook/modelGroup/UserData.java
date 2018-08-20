package ru.stqa.pft.addressbook.modelGroup;

import java.util.Objects;

public class UserData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String home;
    private String mobile;
    private String work;
    private String group;
    private String address;
    private String allPhones;
    private String email1;
    private String email2;
    private String email3;
    private String allEmails;

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
    public String getLastName() {
        return lastName;
    }
    public String getHomePhone() {return home;}
    public String getMobile() {return mobile;}
    public String getWorkPhone() {return work;}
    public String getAllPhones() {
        return allPhones;
    }
    public String getGroup() { return group; }
    public int getId() {
        return id;
    }
    public String getAddress() { return address; }
    public String getEmail1() { return email1; }
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }
    public String getAllEmails() {
        return allEmails;
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
    public UserData withFirstName(String firstName) {
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
    public UserData withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public UserData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public UserData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public UserData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public UserData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public UserData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public UserData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }
}


