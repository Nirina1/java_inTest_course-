package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class UserCreationTest extends UserTestbase{

    @Test
    public void testUserCreationTest() {

        newPersonCreation();
        fillingTheForm(new newPersonData("NewUser", "TestName", "TestLastName", "TestCompany", "4872812406", "example@test.com"));
        submittingPersonCreation();
    }

}
