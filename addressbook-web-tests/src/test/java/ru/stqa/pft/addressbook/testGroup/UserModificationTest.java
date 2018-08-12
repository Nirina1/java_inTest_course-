package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTest extends TestBase{

    @Test

    public void testUserModification() {


        if (! app.getContactHelper().isThereAUser()) {
            app.getContactHelper().createUser(new PersonData("Test", "Testname", null));
        }
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().initPersonModification();
        PersonData user = new PersonData(before.get(before.size() - 1).getId(), "Test1", "Testname1", null);
        app.getContactHelper().fillingTheForm(user, false);
        app.getContactHelper().submitPersonModification();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(user);
        Comparator<? super PersonData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}
