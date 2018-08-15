package com.google.test.support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TextHolder {

    private Properties properties;
    private static TextHolder textHolder;

    public synchronized static TextHolder getInstance() {
        if (textHolder == null) {
            textHolder = new TextHolder();
        }
        return textHolder;
    }

    private TextHolder() {
        if (properties == null) {
            properties = new Properties();
            try {

                properties.load(new FileInputStream("translation_text_" + TestProperties.getInstance().getLocale() + ".txt"));
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }

    public String getText(String key) {
        return this.properties.get(key).toString();
    }
}
