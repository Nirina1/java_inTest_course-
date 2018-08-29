package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static ru.stqa.pft.mantis.tests.TestBase.app;

public class TestUserPasswordChangeAdmin {

    public TestUserPasswordChangeAdmin() throws SQLException {
    }

    @BeforeMethod
    public void startMailServer() {
        app.mail().start ();
    }

    int userId = getUserFromDb().iterator().next().getId();
    private String password = "newPassword";


    @Ignore
    @Test
    public void testChangePassword() throws IOException, MessagingException {
        app.change().loginAsAdmin();
        app.change().resetPassword(userId);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        UserData userData = app.db().userById(userId);
        String confirmationLink = findConfirmationLink(mailMessages, userData.getEmail());
        app.change().newPassword(confirmationLink, password);
        assertTrue(app.newSession().login(userData.getUsername(), password));

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    public Users getUserFromDb() throws SQLException {
        Connection conn = null;
            conn = DriverManager.getConnection ( "jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=" );
            Statement state = conn.createStatement ();
            ResultSet result = state.executeQuery ( "SELECT id, username FROM mantis_user_table" );
            Users users = new Users();
            while (result.next ()) {
                if (!(result.getString ( "username" ).equals ( "administrator" ))) {
                    users.add ( new UserData().withId ( result.getInt ( "id" ) ).withName ( result.getString ( "username" ) ) );
                }
            }
            result.close ();
            state.close ();
            conn.close ();
            return users;
        }

    @AfterMethod
    public void stopMailServer() {
        app.mail().stop();
    }

}


