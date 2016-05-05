package com.mmuzhev.reader;

/**
 * read from string
 */
public class MyStringReader implements ReaderInterface {
    private final char [] src;
    private int count = 0;

    /**
     * Constructor
     * @param src
     * @throws MyReaderException
     */
    public MyStringReader(String src) throws MyReaderException {
        try {
            this.src = src.toCharArray();
        } catch (Exception e) {
            //TODO: add logger
            throw new MyReaderException(e);
        }
    }

    /**
     * check end of string
     * @return true if end
     * @throws MyReaderException
     */
    public boolean checkEnd() throws MyReaderException {
        return count == src.length;
    }

    /**
     * read one symbol
     * @return char symbol
     * @throws MyReaderException
     */
    public char read() throws MyReaderException {
        try {
            char res = src[count];
            count++;

            return res;
        } catch (Exception e) {
            //TODO add logger
            throw new MyReaderException(e);
        }
    }

    /**
     * "close" a string
     * @throws MyReaderException
     */
    public void close() throws MyReaderException {
        count = 0;

    }
}
