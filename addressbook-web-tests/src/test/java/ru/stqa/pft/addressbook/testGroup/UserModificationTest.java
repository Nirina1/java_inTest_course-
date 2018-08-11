package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.HashSet;
import java.util.List;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {


        if (! app.getContactHelper().isThereAUser()) {
            app.getContactHelper().createUser(new PersonData("TestName", "Test1", null));
        }
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().initPersonModification();
        PersonData user = new PersonData(before.get(before.size() - 1).getId(), "TestName1", "TestName1", null);
        app.getContactHelper().fillingTheForm(user, false);
        app.getContactHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(user);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }

}
