package com.mmuzhev.writer;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Write to string
 */
public class StringWriter {

    public StringBuilder result;
    /**
     * Constructor
     * @throws WriterException
     */
    StringWriter(){
        this.result = new StringBuilder();
    }


    /**
     * Write line to string
     * @param formatted line
     * @throws WriterException
     */
    public void write(String formatted) throws WriterException {
        try {
            result.append(formatted);
        } catch (Exception e) {
            //TODO add logger
            throw new WriterException(e);
        }
    }
}
