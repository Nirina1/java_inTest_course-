package ru.stqa.pft.addressbook.testGroup;

import org.testng.annotations.Test;

public class UserDeletionTest extends TestBase {

    @Test
    public void testUserDeletion() {
        app.getGroupHelper().selectUser();
        app.getGroupHelper().deleteUser();
        app.getNavigationHelper().goHomePage();

        }

}


