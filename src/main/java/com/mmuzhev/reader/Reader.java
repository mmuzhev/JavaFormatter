package com.mmuzhev.reader;

import java.io.*;

/**
 * Read from file
 */
public class Reader implements ReaderInterface{
    public FileInputStream text;

    /**
     * Constructor
     * @param text stream
     */
    public Reader(FileInputStream text) {
        this.text = text;

    }

    /**
     * read 1 symbol
     * @return char symbol
     * @throws ReaderException
     */
    public char read() throws ReaderException {
        char result = '0';
        try {
            result = (char)text.read();
        }
        catch (IOException e){
            throw new ReaderException(e);
        }
        return result;
    }

    /**
     * check end of stream
     * @return true if end
     * @throws ReaderException
     */
    public boolean checkEnd() throws ReaderException {
        boolean a = false;
        try {
            a =( text.available() < 1);
        }
        catch (IOException e){
            throw new ReaderException(e);
        }
        return a;
    }

    /**
     * close reading stream
     * @throws ReaderException
     */
    public void close() throws ReaderException {
        try {
            text.close();
        }
        catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}