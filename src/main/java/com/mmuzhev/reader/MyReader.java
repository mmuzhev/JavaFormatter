package com.mmuzhev.reader;

import java.io.*;

/**
 * Read from file
 */
public class MyReader implements ReaderInterface{
    public FileInputStream text;

    /**
     * Constructor
     * @param text stream
     */
    public MyReader(FileInputStream text) {
        this.text = text;

    }

    /**
     * read 1 symbol
     * @return char symbol
     * @throws MyReaderException
     */
    public char read() throws MyReaderException {
        char result = '0';
        try {
            result = (char)text.read();
        }
        catch (IOException e){
            throw new MyReaderException(e);
        }
        return result;
    }

    /**
     * check end of stream
     * @return true if end
     * @throws MyReaderException
     */
    public boolean checkEnd() throws MyReaderException {
        boolean a = false;
        try {
            a =( text.available() < 1);
        }
        catch (IOException e){
            throw new MyReaderException(e);
        }
        return a;
    }

    /**
     * close reading stream
     * @throws MyReaderException
     */
    public void close() throws MyReaderException {
        try {
            text.close();
        }
        catch (IOException e) {
            throw new MyReaderException(e);
        }
    }
}