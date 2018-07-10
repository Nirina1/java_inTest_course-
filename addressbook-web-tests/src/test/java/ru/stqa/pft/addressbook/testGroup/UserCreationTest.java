package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;


public class UserCreationTest extends TestBase {

    @Test
    public void testUserCreationTest() {

        app.getGroupHelper().newPersonCreation();
        app.getGroupHelper().fillingTheForm(new PersonData("NewUser", "TestName", "TestLastName", "TestCompany", "4872812406", "example@testGroup.com"));
        app.getGroupHelper().submittingPersonCreation();
    }

}
