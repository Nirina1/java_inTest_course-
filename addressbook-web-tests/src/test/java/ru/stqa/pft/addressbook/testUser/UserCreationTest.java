package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelUser.PersonData;

public class UserCreationTest extends UserTestbase {

    @Test
    public void testUserCreationTest() {

        applicationTestUser.getUserHelper().newPersonCreation();
        applicationTestUser.getUserHelper().fillingTheForm(new PersonData("NewUser", "TestName", "TestLastName", "TestCompany", "4872812406", "example@testGroup.com"));
        applicationTestUser.getUserHelper().submittingPersonCreation();
    }

}
