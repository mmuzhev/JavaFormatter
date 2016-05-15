package com.mmuzhev.reader;

/**
 * read from string
 */
public class StringReader implements ReaderInterface {
    private final char [] src;
    private int count = 0;

    /**
     * Constructor
     * @param src read this
     * @throws ReaderException
     */
    public StringReader(String src) throws ReaderException {
        try {
            this.src = src.toCharArray();
        } catch (Exception e) {
            //TODO: add logger
            throw new ReaderException(e);
        }
    }

    /**
     * check end of string
     * @return true if end
     * @throws ReaderException
     */
    public boolean checkEnd() throws ReaderException {
        return count == src.length;
    }

    /**
     * read one symbol
     * @return char symbol
     * @throws ReaderException
     */
    public char read() throws ReaderException {
        try {
            char res = src[count];
            count++;

            return res;
        } catch (Exception e) {
            //TODO add logger
            throw new ReaderException(e);
        }
    }

    /**
     * "close" a string
     * @throws ReaderException
     */
    public void close() throws ReaderException {
        count = 0;

    }
}
