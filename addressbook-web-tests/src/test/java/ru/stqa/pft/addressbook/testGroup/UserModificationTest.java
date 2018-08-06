package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {


        if (! app.getContactHelper().isThereAUser()) {
            app.getContactHelper().createUser(new PersonData("NewUser", "TestName", "Test1", "TestCompany"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectUser(before);
        app.getContactHelper().initPersonModification();
        app.getContactHelper().fillingTheForm(new PersonData("NewUser111", "TestName111", null, "TestCompany"), false);
        app.getContactHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }

}
