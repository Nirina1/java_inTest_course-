package ru.stqa.pft.addressbook.testGroup;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserModificationTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new UserData().withName("test1").withLastName("test1").withGroup("test1"));
        }
    }

    @Test

    public void testUserModification() {

        Users before = app.contacts().all();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId()).withName("Test01").withLastName("TestName1");
        app.contacts().modify(user);
        Users after = app.contacts().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));

    }
}

