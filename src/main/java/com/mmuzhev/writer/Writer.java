package com.mmuzhev.writer;

import java.io.*;

/**
 * write to file
 */
public class Writer implements WriterInterface {
    public PrintWriter code;

    /**
     * Constructor
     * @param code line
     */
    public Writer(PrintWriter code) {
        this.code = code;
    }

    /**
     * write to file
     * @param param writed string
     * @throws WriterException
     */
    public void write(String param) throws WriterException {
       try {
           code.print(param);
       }
       catch (Exception e) {
           throw new WriterException(e);
       }
    }

    /**
     * close output stream
     */
    public void close() {
        code.close();
    }
}
