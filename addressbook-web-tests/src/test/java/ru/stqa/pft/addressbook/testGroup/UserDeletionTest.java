package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class UserDeletionTest extends TestBase {

    @Test
    public void testUserDeletion() {

        int before = app.getContactHelper().getContactCount();


        if (! app.getContactHelper().isThereAUser()) {
              app.getContactHelper().createUser(new PersonData("NewUser", "TestName", null, "TestCompany"));
        }
        app.getContactHelper().selectUser(before);
        app.getContactHelper().deleteUser();
        app.getNavigationHelper().goHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);

        }

}


