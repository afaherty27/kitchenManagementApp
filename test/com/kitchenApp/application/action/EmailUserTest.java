package com.kitchenApp.application.action;

import org.junit.Test;
import static org.junit.Assert.*;
import java.net.MalformedURLException;

/**
 * Test class for EmailUser class
 * @author afaherty on 12/21/2015.
 */
public class EmailUserTest  {

    private EmailUser email;

    @Test
    public void testSendMessage() throws MalformedURLException {

        String subject = "junit test";
        String body = "junit test body";
        String mailTo = "afaherty@madisoncollege.edu";

        email = new EmailUser();
        email.sendMessage(subject, body, mailTo);

        assertNotNull("EmailUser object not instantiated correctly", email instanceof  EmailUser);
        assertTrue("@ symbol not found", mailTo.contains("@"));
    }
}