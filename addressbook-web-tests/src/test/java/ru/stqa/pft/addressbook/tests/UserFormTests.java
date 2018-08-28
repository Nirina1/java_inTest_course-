package ru.stqa.pft.addressbook.tests;

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
        if (app.users().all().size() == 0) {
            app.users().create(new UserData()
                    .withFirstName("TestName")
                    .withLastName("LastName")
                    .withHomePhone("4343")
                    .withMobile("2222")
                    .withWorkPhone("445")
                    .withEmail1("test1@test.com")
                    .withEmail2("test2@test.com")
                    .withEmail3("test3@test.com")
                    .withAddress("Krakow"));
                    //.inGroup(groupData));
        }
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    @Test
    public void testUserPhones() {
        app.goTo().goHomePage();
        UserData user = app.users().all().iterator().next();
        UserData userInfoFromEditForm = app.users().infoFromEditForm(user);

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
        UserData user = app.users().all().iterator().next();
        UserData userInfoFromEditForm = app.users().infoFromEditForm(user);

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
        UserData user = app.users().all().iterator().next();
        UserData userInfoFromEditForm = app.users().infoFromEditForm(user);

        assertThat(user.getAllEmails(), equalTo(mergeEmails(userInfoFromEditForm)));

    }

    private String mergeEmails(UserData user) {
        return Arrays.asList(user.getEmail1(), user.getEmail2(), user.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(UserFormTests::cleaned)
                .collect(Collectors.joining("\n"));
    }



}
