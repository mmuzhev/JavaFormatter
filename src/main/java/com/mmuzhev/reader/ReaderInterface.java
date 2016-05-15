package com.mmuzhev.reader;

public interface ReaderInterface {
    char read() throws ReaderException;
    boolean checkEnd() throws ReaderException;
    void close() throws ReaderException;

}
