package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;


public class UserCreationTest extends TestBase {

    @Test
    public void testUserCreationTest() {
        app.getNavigationHelper().goHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().newPersonCreation();
        app.getContactHelper().fillingTheForm(new PersonData("NewUser", "TestName", "test1", "TestCompany"), true);
        app.getContactHelper().submittingPersonCreation();
        app.getNavigationHelper().goHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
