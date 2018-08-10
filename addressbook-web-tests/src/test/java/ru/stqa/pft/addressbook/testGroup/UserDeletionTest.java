package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.List;

public class UserDeletionTest extends TestBase {

    @Test
    public void testUserDeletion() {


        if (! app.getContactHelper().isThereAUser()) {
              app.getContactHelper().createUser(new PersonData("NewUser", "TestName", null, "TestCompany"));
        }
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().deleteUser();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        }

}


