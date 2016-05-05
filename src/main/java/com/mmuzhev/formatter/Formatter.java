package com.mmuzhev.formatter;
/*
 * formatter class
 */

public class Formatter implements FormatterInterface {
    private int spaceCount = 0;

    /**
     * format symbol to Java-code view
     * @param symbol needed to format
     * @return formatted string
     */
    public String format(char symbol) {
        StringBuilder result = new StringBuilder();
        switch (symbol) {
            case ';': {
                result.append(symbol);
                result.append("\n");
                result.append(forSpace(spaceCount));
                break;
            }
            case '{' : {
                result.append(symbol);
                spaceCount += 4;
                result.append("\n");
                result.append(forSpace(spaceCount));
                break;
            }
            case '}' : {
                if (spaceCount >= 8) {
                    spaceCount -= 8;
                    result.substring(0);
                    result.append("\n");
                    result.append(forSpace(spaceCount));
                    result.append(symbol);
                    result.append("\n");
                    break;
                }
                else {
                    spaceCount = 0;
                    result.substring(0);
                    result.append("\n");
                    result.append(forSpace(spaceCount));
                    result.append(symbol);
                    result.append("\n");
                    break;
                }
            }
            default:{
                result.append(symbol);
            }
        }
        return result.toString();
    }

    /**
     * print some spaces
     * @param quantity of spaces
     * @return string with spaces
     */
    private String forSpace(int quantity) {
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < quantity; i++)
            a.append(" ");
        return a.toString();
    }
}
