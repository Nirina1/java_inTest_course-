package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test", "test", "My_group"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
