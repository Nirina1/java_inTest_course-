package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.List;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {


        if (! app.getContactHelper().isThereAUser()) {
            app.getContactHelper().createUser(new PersonData("NewUser", "TestName", "Test1", "TestCompany"));
        }
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectUser(before.size() -1);
        app.getContactHelper().initPersonModification();
        app.getContactHelper().fillingTheForm(new PersonData("NewUser111", "TestName111", null, "TestCompany"), false);
        app.getContactHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

    }

}
