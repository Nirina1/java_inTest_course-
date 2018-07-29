package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {


        if (! app.getGroupHelper().isThereAUser()) {
            app.getGroupHelper().createUser(new PersonData("NewUser", "TestName", "Test1", "TestCompany", "4872812406", "example@testGroup.com"));
        }
        app.getGroupHelper().selectUser();
        app.getGroupHelper().initPersonModification();
        app.getGroupHelper().fillingTheForm(new PersonData("NewUser111", "TestName111", null, "TestCompany", "4872812406", "example@testGroup.com"), false);
        app.getGroupHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();

    }

}
