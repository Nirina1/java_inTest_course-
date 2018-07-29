package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class UserDeletionTest extends TestBase {

    @Test
    public void testUserDeletion() {

        app.getGroupHelper().selectUser();

        if (! app.getGroupHelper().isThereAUser()) {
              app.getGroupHelper().createUser(new PersonData("NewUser", "TestName", "Test1", "TestCompany", "4872812406", "example@testGroup.com"));
        }
        app.getGroupHelper().deleteUser();
        app.getNavigationHelper().goHomePage();

        }

}


