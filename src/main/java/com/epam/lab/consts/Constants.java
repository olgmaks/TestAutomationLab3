package com.epam.lab.consts;

import com.epam.lab.models.Message;
import com.epam.lab.models.User;


public interface Constants {
    User [] users = {new User("Test", "Test", "selenium.test.v.lohvyniuk@gmail.com", "wylsselenium?"),
                    new User("Test2", "Test2", "selenium.test.v.lohvyniuk2@gmail.com", "wylsselenium?"),
            new User("Test2", "Test2", "selenium.test.v.lohvyniuk3@gmail.com", "wylsselenium?")};
    Message [] messages = {new Message("volodymyr.lohvyniuk@gmail.com", "cc_cc@gmail.com", "bcc_bcc@gmail.com",
            "Hey, whats up?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")
    , new Message("volodymyr.lohvyniuk@gmail.com", "cc_cc@gmail.com", "bcc_bcc@gmail.com",
            "EPAM Please check your mailbox", "Hello, I`m writing you to test WebDriver")};
    }
