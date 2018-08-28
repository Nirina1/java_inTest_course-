package ru.stqa.pft.addressbook.modelGroup;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XStreamAlias("user")
@Entity
@Table(name = "addressbook")
public class UserData {
    @XStreamOmitField
    @Id
    @Column (name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column (name = "firstname")
    private String firstName;

    @Expose
    @Column (name = "lastname")
    private String lastName;

    @Expose
    @Column (name = "home")
    @Type(type = "text")
    private String home;

    @Expose
    @Column (name = "mobile")
    @Type(type = "text")
    private String mobile;

    @Expose
    @Column (name = "work")
    @Type(type = "text")
    private String work;

    @Expose
    @Column (name = "address")
    @Type(type = "text")
    private String address;

    @Transient
    private String allPhones;

    @Column (name = "email")
    @Type(type = "text")
    private String email1;

    @Column (name = "email2")
    @Type(type = "text")
    private String email2;

    @Column (name = "email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allEmails;

    @Column (name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups"
            , joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                Objects.equals(firstName, userData.firstName) &&
                Objects.equals(lastName, userData.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }



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
    public File getPhoto() {
        return new File(photo);
    }
    public Groups getGroups() { return new Groups(groups);}

    public UserData inGroup(GroupData group) {
        groups.add(group);
        return this;
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

    public UserData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }





}


