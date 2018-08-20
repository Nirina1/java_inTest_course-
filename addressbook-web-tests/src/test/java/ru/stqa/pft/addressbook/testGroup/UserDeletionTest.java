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
            app.contacts().create(new UserData().withFirstName("name1")
                    .withLastName("lastname1").withGroup("test1").withHomePhone("123").withMobile("1111").withWorkPhone("2342")
                    .withAddress("Krakow").withEmail1("test@t.com").withEmail2("test@t2.com").withEmail3("test@t3.com"));
        }
    }

    @Test
    public void testUserDeletion() {
        Users before = app.contacts().all();
        UserData deletedUser = before.iterator().next();
        app.contacts().delete(deletedUser);
        assertThat(app.contacts().getContactCount(), equalTo(before.size() - 1));
        Users after = app.contacts().all();
        assertThat(after, equalTo(before.without(deletedUser)));

        }
}


