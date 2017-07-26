package com.epam.labs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GmailPropertyUtil {
    private Properties properties;
    private final static String GMAIL_PROPERTY = "gmail.properties";

    public GmailPropertyUtil() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(GMAIL_PROPERTY);
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file " + GMAIL_PROPERTY + " not found in the classpath");
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getSubject() {
        return properties.getProperty("subject");
    }

    public String getBody() {
        return properties.getProperty("body");
    }
}
