package epam.com.lab.model;


import epam.com.lab.Constants1;

import java.io.IOException;

public class Letter {


    private String to;

    private String subject;

    private String shortContent;

    public Letter(String to, String subject, String shortContent) {
        this.to = to;
        this.subject = subject;
        this.shortContent = shortContent;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShortContent() {
        return shortContent;
    }


}
