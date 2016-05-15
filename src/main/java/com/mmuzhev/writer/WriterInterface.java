package com.mmuzhev.writer;

/**
 * write somewhere (file or string for example)u
 */
public interface WriterInterface {
    void write (String param) throws WriterException;
    void close() throws WriterException;
}
