package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.GroupData;
import ru.stqa.pft.addressbook.modelGroup.Groups;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserAddingToGroupTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().users().size() == 0) {
            Groups groups = app.db().groups();
            GroupData groupData;

            if (groups.isEmpty()) {
                app.goTo().groupPage();
                groupData = new GroupData().withName("new_group").withHeader("header1").withFooter("footer1");
                app.group().create(groupData);
            } else {
                groupData = groups.iterator().next();
            }
            app.users().create(new UserData()
                    .withFirstName("TestName").withLastName("LastName")
                    .withHomePhone("4343").withMobile("2222").withWorkPhone("4545")
                    .withEmail1("test1@test.com").withEmail2("test2@test.com").withEmail3("test3@test.com")
                    .withAddress("Krakow")
                    .inGroup(groupData));
        }

    }

    @Test
    public void testUserAddingToGroup() {
        Users before = app.db().users();
        UserData addedContact = before.iterator().next();
        app.users().add(addedContact);
        assertThat(app.users().getContactCount(), CoreMatchers.equalTo(before.size()));
        Users after = app.db().users();
        assertThat(after, equalTo(before));
        verifyUserListInUI();

    }


}
