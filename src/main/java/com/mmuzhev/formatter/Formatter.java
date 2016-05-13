package com.mmuzhev.formatter;
/*
 * formatter class
 */

public class Formatter implements FormatterInterface {
    private int spaceCount = 0;
    private boolean enter = false;

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
                //result.append(forSpace(spaceCount));
                enter = true;
                break;
            }
            case '{' : {
                result.append(forSpace(1));
                result.append(symbol);
                spaceCount += 4;
                result.append("\n");
                //result.append(forSpace(spaceCount));
                enter = true;
                break;
            }
            case '=' : {
                result.append(forSpace(1));
                result.append(symbol);
                result.append(forSpace(1));
                break;
            }
            case '}' : {
                if (spaceCount >= 4) {
                    spaceCount -= 4;
                    result.substring(0);
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
                if(enter){
                    enter = false;
                    result.append(forSpace(spaceCount));
                    result.append(symbol);
                }
                else result.append(symbol);
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
