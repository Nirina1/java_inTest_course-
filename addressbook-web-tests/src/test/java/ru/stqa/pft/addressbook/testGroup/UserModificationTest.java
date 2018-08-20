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
            app.contacts().create(new UserData().withFirstName("name1")
                    .withLastName("lastname1").withGroup("test1").withHomePhone("123").withMobile("1111").withWorkPhone("2342")
            .withAddress("Krakow").withEmail1("test@t.com").withEmail2("test@t2.com").withEmail3("test@t3.com"));
        }
    }

    @Test

    public void testUserModification() {

        Users before = app.contacts().all();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId()).withFirstName("Test01").withLastName("TestName1");
        app.contacts().modify(user);
        assertThat(app.contacts().getContactCount(), equalTo(before.size()));
        Users after = app.contacts().all();
        assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));

    }
}

