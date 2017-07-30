package com.epam.labs.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class CommonUtil {
    public static Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(CommonUtil.class.getResourceAsStream(relativePath), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unable to read input", e);
        }
    }
}
