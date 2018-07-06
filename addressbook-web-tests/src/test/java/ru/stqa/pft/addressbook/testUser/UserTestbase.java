package ru.stqa.pft.addressbook.testUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanagerUser.ApplicationTestUser;

public class UserTestbase {


    protected final ApplicationTestUser applicationTestUser = new ApplicationTestUser();

    @BeforeMethod
    public void setUp() throws Exception {
        applicationTestUser.init();
    }

    @AfterMethod
    public void tearDown() {

        applicationTestUser.stop();
    }

}
