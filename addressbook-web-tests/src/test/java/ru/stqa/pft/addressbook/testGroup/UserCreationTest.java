package ru.stqa.pft.addressbook.testGroup;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.modelGroup.PersonData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class UserCreationTest extends TestBase {

    @Test
    public void testUserCreationTest() {
        app.getNavigationHelper().goHomePage();
        List<PersonData> before = app.getContactHelper().getContactList();
        app.getContactHelper().newPersonCreation();
        PersonData user = new PersonData("TestName2", "TestName1", "test1");
        app.getContactHelper().fillingTheForm(user,true);
        app.getContactHelper().submittingPersonCreation();
        app.getNavigationHelper().goHomePage();
        List<PersonData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

       user.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

        before.add(user);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
