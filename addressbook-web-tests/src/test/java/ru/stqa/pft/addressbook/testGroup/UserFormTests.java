package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserFormTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new UserData().withFirstName("name1")
                    .withLastName("lastname1").withGroup("test1").withHomePhone("123").withMobile("1111").withWorkPhone("2342")
                    .withAddress("Krakow").withEmail1("test@t.com").withEmail2("test@t2.com").withEmail3("test@t3.com"));
        }
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    @Test
    public void testUserPhones() {
        app.goTo().goHomePage();
        UserData user = app.contacts().all().iterator().next();
        UserData userInfoFromEditForm = app.contacts().infoFromEditForm(user);

        assertThat(user.getAllPhones(), equalTo(mergePhones(userInfoFromEditForm)));
    }

    private String mergePhones(UserData user) {
        return Arrays.asList(user.getHomePhone(), user.getMobile(), user.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(UserFormTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    @Test
    public void testUserAddress() {
        app.goTo().goHomePage();
        UserData user = app.contacts().all().iterator().next();
        UserData userInfoFromEditForm = app.contacts().infoFromEditForm(user);

        assertThat(user.getAddress(), equalTo(mergeAddress(userInfoFromEditForm)));

    }

    private String mergeAddress(UserData user) {
        return Arrays.asList(user.getAddress())
                .stream().filter((s) -> ! s.equals(""))
                .map(UserFormTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    @Test
    public void testUserEmails() {
        app.goTo().goHomePage();
        UserData user = app.contacts().all().iterator().next();
        UserData userInfoFromEditForm = app.contacts().infoFromEditForm(user);

        assertThat(user.getAllEmails(), equalTo(mergeEmails(userInfoFromEditForm)));

    }

    private String mergeEmails(UserData user) {
        return Arrays.asList(user.getEmail1(), user.getEmail2(), user.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(UserFormTests::cleaned)
                .collect(Collectors.joining("\n"));
    }



}
