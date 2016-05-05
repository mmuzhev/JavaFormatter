package com.mmuzhev.writer;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Write to string
 */
public class MyStringWriter implements  WriterInterface {
    private final OutputStreamWriter stream;

    /**
     * Constructor
     * @param stream of output
     * @throws MyWriterException
     */
    public MyStringWriter(OutputStreamWriter stream) throws MyWriterException {
        try {
            this.stream = stream;
        } catch (Exception e) {
            //TODO: add logger
            throw new MyWriterException(e);
        }
    }

    /**
     * Write line to string
     * @param formatted line
     * @throws MyWriterException
     */
    public void write(String formatted) throws MyWriterException {
        try {
            stream.write(formatted);
        } catch (IOException e) {
            //TODO add logger
            throw new MyWriterException(e);
        }
    }

    /**
     * close output stream
     * @throws MyWriterException
     */
    public void close() throws MyWriterException {
        try {
            stream.flush();
            stream.close();
        } catch (IOException e) {
            //TODO
            throw new MyWriterException(e);
        }
    }
}
