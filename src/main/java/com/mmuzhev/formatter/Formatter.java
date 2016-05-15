package com.mmuzhev.formatter;
/*
 * formatter class
 */

public class Formatter implements FormatterInterface {
    private int spaceCount = 0;
    private boolean enter = false;
    private int ForLogic = 0;
    private char PreviousLogicalSymbol = ' ';

    /**
     * format symbol to Java-code view
     * @param symbol needed to format
     * @return formatted string
     */
    public String format(char symbol) {
        StringBuilder result = new StringBuilder();
        char symbol1 = ' ';
        char symbol2 = ' ';

        // few similar cases in one
        if (symbol == '=' || symbol == '+' || symbol == '-' || symbol == '*' ) {

            symbol1 = symbol;
            symbol = '=';
        }
        if ( symbol == '&' || symbol == '|' ) {

            symbol2 = symbol;
            symbol = '&';
        }
        else if(ForLogic == 1) {
            result.append(PreviousLogicalSymbol);
            ForLogic = 0;
        }

        switch (symbol) {
            case ';': {
                ForLogic = 0;
                result.append(symbol);
                result.append("\n");
                enter = true;
                break;
            }
            case '{' : {
                ForLogic = 0;
                result.append(forSpace(1));
                result.append(symbol);
                spaceCount += 4;
                result.append("\n");
                enter = true;
                break;
            }
            case '=' : {
                ForLogic = 0;
                result.append(forSpace(1));
                result.append(symbol1);
                result.append(forSpace(1));
                break;
            }
            case '}' : {
                ForLogic = 0;
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
            case '(' : {
                result.append(forSpace(1));
                result.append(symbol);
                break;
            }
            case ')' : {
                result.append(symbol);
                result.append(forSpace(1));
                break;
            }
            case '&' : {
                if (ForLogic == 1) {
                    result.append(forSpace(1));
                    result.append(symbol2);
                    result.append(symbol2);
                    result.append(forSpace(1));
                    ForLogic = 0;
                }
                else {
                    ForLogic = 1;
                    PreviousLogicalSymbol = symbol2;
                }
                break;
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
