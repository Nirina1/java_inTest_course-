package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelUser.PersonData;

public class UserCreationTest extends TestbaseUser {

    @Test
    public void testUserCreationTest() {

        app.getUserHelper().newPersonCreation();
        app.getUserHelper().fillingTheForm(new PersonData("NewUser", "TestName", "TestLastName", "TestCompany", "4872812406", "example@testGroup.com"));
        app.getUserHelper().submittingPersonCreation();
    }

}
