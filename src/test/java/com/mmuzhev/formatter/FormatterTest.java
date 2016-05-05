package com.mmuzhev.formatter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FormatterTest {
    Formatter formatter;

    @Before
    public void setUp() throws Exception {
        formatter = new Formatter();
    }

    @Test
    public void correctlyFormatText() throws FormatterException {
        String str1 = "kuhg,jhgb() {ljhljbj;}";
        String str2 = "kuhg,jhgb() {\n    ljhljbj;\n    \n}\n";

        assertEquals(str2, format(str1));
    }

    private String format(String src) throws FormatterException {
        StringBuilder result = new StringBuilder();
        for (char c : src.toCharArray()) {
           result.append(formatter.format(c));
        }

        return result.toString();
    }
}
