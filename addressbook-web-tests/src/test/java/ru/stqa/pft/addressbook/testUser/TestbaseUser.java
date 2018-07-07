package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanagerUser.ApplicationManagementUser;

public class TestbaseUser {


    protected final ApplicationManagementUser app = new ApplicationManagementUser();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
