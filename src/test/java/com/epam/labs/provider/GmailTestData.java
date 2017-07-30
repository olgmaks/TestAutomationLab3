package com.epam.labs.provider;

import com.epam.labs.model.Message;
import com.epam.labs.model.User;
import com.epam.labs.util.CommonUtil;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.testng.annotations.DataProvider;

import java.util.List;

public class GmailTestData {

    private final static String USERS_DATA_PATH = "/users.csv";
    private final static String MESSAGES_DATA_PATH = "/messages.csv";
    private final static int DIMENSION = 2;

    @DataProvider(name = "provideUsersAndMessages", parallel = true)
    public static Object[][] provideUsersAndMessages() {

        BeanListProcessor<User> processor = new BeanListProcessor<>(User.class);
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setProcessor(processor);
        parserSettings.setHeaderExtractionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);
        parser.parse(CommonUtil.getReader(USERS_DATA_PATH));
        List<User> users = processor.getBeans();

        BeanListProcessor<Message> messageProcessor = new BeanListProcessor<>(Message.class);
        parserSettings.setProcessor(messageProcessor);
        parser = new CsvParser(parserSettings);
        parser.parse(CommonUtil.getReader(MESSAGES_DATA_PATH));
        List<Message> messages = messageProcessor.getBeans();

        int size = users.size();
        Object[][] twoDimList = new Object[size][DIMENSION];
        for (int i = 0; i < size; i++) {
            twoDimList[i][0] = users.get(i);
            twoDimList[i][1] = messages.get(0);
        }
        return twoDimList;
    }
}
