package com.mmuzhev.writer;

import java.io.*;

/**
 * write to file
 */
public class MyWriter implements WriterInterface {
    public PrintWriter code;

    /**
     * Constructor
     * @param code line
     */
    public MyWriter(PrintWriter code) {
        this.code = code;
    }

    /**
     * write to file
     * @param param writed string
     * @throws MyWriterException
     */
    public void write(String param) throws MyWriterException {
       try {
           code.print(param);
       }
       catch (Exception e) {
           throw new MyWriterException(e);
       }
    }

    /**
     * close output stream
     */
    public void close() {
        code.close();
    }
}
