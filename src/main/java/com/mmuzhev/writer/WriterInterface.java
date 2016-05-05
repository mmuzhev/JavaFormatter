package com.mmuzhev.writer;

/**
 * write somewhere (file or string for example)u
 */
public interface WriterInterface {
    void write (String param) throws MyWriterException;
    void close() throws MyWriterException;
}
