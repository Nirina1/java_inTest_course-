package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.List;


public class UserCreationTest extends TestBase {

    @Test
    public void testUserCreationTest() {
        app.getNavigationHelper().goHomePage();
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().newPersonCreation();
        app.getContactHelper().fillingTheForm(new PersonData("NewUser", "TestName", "test1", "TestCompany"), true);
        app.getContactHelper().submittingPersonCreation();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
