package com.mmuzhev.reader;

public interface ReaderInterface {
    char read() throws MyReaderException;
    boolean checkEnd() throws MyReaderException;
    void close() throws MyReaderException;

}
