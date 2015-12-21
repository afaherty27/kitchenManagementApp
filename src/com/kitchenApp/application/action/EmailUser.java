package com.kitchenApp.application.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * Sends users an email through mademailservice
 * @author afaherty
 * @version 1.0 on 12/21/2015
 */
public class EmailUser {

    protected static String EMAIL_URL_FRONT = "http://tomcat-mademailservice.rhcloud.com/NewEmailWebservice_war/rest/sendEmail/";

    public void sendMessage(String subject, String body, String mailTo) {

        String response = "";

        try {

            EmailUser urlConnection = new EmailUser();
            URL url = urlConnection.getEmailUrl(subject, body, mailTo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response += line;
            }
            reader.close();
            System.out.println("The response was: " + response);

        } catch (MalformedURLException e) {
            System.out.println("malformed url");
        } catch (IOException e) {
            System.out.println("io exception");
            e.printStackTrace();
        }
    }

    /**
     * Builds and returns a URL for the search.books method
     *
     * @param recipient The email address of the recipient
     * @param subject The subject of the email
     * @param body The body of the email massage
     */
    public URL getEmailUrl(String recipient, String subject, String body) throws MalformedURLException {

        recipient = encodeString(recipient);
        subject = encodeString(subject);
        body = encodeString(body);

        String url = EMAIL_URL_FRONT + recipient + "/" + subject + "/" + body;

        return new URL(url);
    }

    /**
     * Encodes the string to a URL, manually replacing "+" with "%20" and
     * "'" with "%27".
     *
     * @param path The URL path to encode
     */
    public String encodeString(String path) {

        String url = URLEncoder.encode(path).replace("+", "%20").replace("'", "%27");

       /* return the encoded URI manually escape the single quote character */
        return url;
    }
}
