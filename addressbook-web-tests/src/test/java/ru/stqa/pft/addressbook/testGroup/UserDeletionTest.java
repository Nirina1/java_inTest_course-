package ru.stqa.pft.addressbook.testGroup;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class UserDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new UserData().withName("test1"));
        }
    }

    @Test
    public void testUserDeletion() {
        Users before = app.contacts().all();
        UserData deletedUser = before.iterator().next();
        app.contacts().delete(deletedUser);
        Users after = app.contacts().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedUser)));

        }
}


