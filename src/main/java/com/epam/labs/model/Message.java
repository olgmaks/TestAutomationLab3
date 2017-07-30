package com.epam.labs.model;

import com.univocity.parsers.annotations.Parsed;

public class Message {

    @Parsed(field = "to")
    private String to;

    @Parsed(field = "subject")
    private String subject;

    @Parsed(field = "body")
    private String body;

    public Message() {
    }

    public Message(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
