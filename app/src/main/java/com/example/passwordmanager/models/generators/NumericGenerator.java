package com.example.passwordmanager.models.generators;

import com.example.passwordmanager.models.Helper.Helper;

public class NumericGenerator extends PasswordGenerator {
    private static final char CHAR_0 = '0';
    private static final char CHAR_9 = '9';

    @Override
    public String getChar() {
        return String.valueOf((char) (Helper.randomChar(CHAR_0,CHAR_9)));
    }
}
