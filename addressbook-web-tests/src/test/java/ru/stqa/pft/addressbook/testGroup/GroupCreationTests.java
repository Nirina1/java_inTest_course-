package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modelGroup.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("testGroup", "testGroup", "My_group"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
