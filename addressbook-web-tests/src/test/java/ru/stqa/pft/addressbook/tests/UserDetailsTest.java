package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDetailsTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().users().size() == 0) {
            app.users().create(new UserData().withFirstName("UserName").withLastName("UserLastNAme")
                    .withAddress("Krakow").withHomePhone("1212").withMobile("2525")
                    .withWorkPhone("333").withEmail1("example@test.com").withEmail2("example2@test.com")
                    .withEmail3("example3@test.com"));
        }
    }
    @Test
    public void testUserDetails() {
        app.goTo().goHomePage();
        Users users = app.db().users();
        UserData user = users.iterator().next();
        UserData userInfoFromDetailsForm = app.users().infoFromDetailsForm(user);
        app.goTo().goHomePage();
        assertThat(user.getFirstName(), equalTo(userInfoFromDetailsForm.getFirstName()));
        assertThat(user.getLastName(), equalTo(userInfoFromDetailsForm.getLastName()));
        assertThat(user.getAddress(), equalTo(userInfoFromDetailsForm.getAddress()));
        assertThat(user.getHomePhone(), equalTo(userInfoFromDetailsForm.getHomePhone()));
        assertThat(user.getMobile(), equalTo(userInfoFromDetailsForm.getMobile()));
        assertThat(user.getWorkPhone(), equalTo(userInfoFromDetailsForm.getWorkPhone()));
        assertThat(user.getEmail1(), equalTo(userInfoFromDetailsForm.getEmail1()));
        assertThat(user.getEmail2(), equalTo(userInfoFromDetailsForm.getEmail2()));
        assertThat(user.getEmail3(), equalTo(userInfoFromDetailsForm.getEmail3()));

    }


}
