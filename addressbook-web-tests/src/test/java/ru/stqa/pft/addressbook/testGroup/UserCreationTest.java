package ru.stqa.pft.addressbook.testGroup;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class UserCreationTest extends TestBase {

    @Test
    public void testUserCreationTest() {
        app.goTo().goHomePage();
        Users before = app.contacts().all();
        UserData user = new UserData().withFirstName("test10").withLastName("test").withGroup("test1");
        app.contacts().create(user);
        assertThat(app.contacts().getContactCount(), equalTo(before.size() + 1));
        Users after = app.contacts().all();
        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
