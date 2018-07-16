package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {

        app.getGroupHelper().selectUser();
        app.getGroupHelper().initPersonModification();
        app.getGroupHelper().fillingTheForm(new PersonData("NewUser111", "TestName111", "Test111", "TestCompany", "4872812406", "example@testGroup.com"));
        app.getGroupHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();

    }

}
