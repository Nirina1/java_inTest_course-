package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.Test;

public class UserDeletionTest extends TestbaseUser {

    @Test
    public void testUserDeletion() {
        app.getUserHelper().deleteUser();
        app.getUserHelper().goHomePage();

        }

}


