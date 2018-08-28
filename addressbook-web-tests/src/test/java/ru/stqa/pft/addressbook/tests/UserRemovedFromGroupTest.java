package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.GroupData;
import ru.stqa.pft.addressbook.modelGroup.Groups;
import ru.stqa.pft.addressbook.modelGroup.UserData;
import ru.stqa.pft.addressbook.modelGroup.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRemovedFromGroupTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().users().size() == 0) {
            Groups groups = app.db().groups();
            GroupData groupData;

            if (app.db().groups().isEmpty()) {
                app.goTo().groupPage();
                groupData = new GroupData().withName("test1").withHeader("test1").withFooter("test1");
                app.group().create(groupData);
            } else {
                groupData = groups.iterator().next();
            }
            app.users().create(new UserData()
                    .withFirstName("TestName")
                    .withLastName("LastName")
                    .withHomePhone("4343")
                    .withMobile("2222")
                    .withWorkPhone("4545")
                    .withEmail1("test1@test.com")
                    .withEmail2("test2@test.com")
                    .withEmail3("test3@test.com")
                    .withAddress("Krakow")
                    .inGroup(groupData));
        }
    }

    @Test
    public void testUserRemovedFromGroup() {
        Users before = app.db().users();
        UserData deletedUser = before.iterator().next();
        Groups group = app.db().groups();
        GroupData firstgroup = group.iterator().next();
        if (deletedUser.getGroups().isEmpty()) {
            UserData addedContact = before.iterator().next();
            app.users().add(addedContact);
        }
        app.users().removeFromGroup(deletedUser, firstgroup);
        assertThat(app.users().getContactCount(), equalTo(before.size()));
        Users after = app.db().users();
        assertThat(after, equalTo(before));
        verifyUserListInUI();

    }

}
