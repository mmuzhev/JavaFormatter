package com.mmuzhev.formatter;

import com.mmuzhev.reader.MyReader;
import com.mmuzhev.reader.MyReaderException;
import com.mmuzhev.writer.MyWriter;
import com.mmuzhev.writer.MyWriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Formatting process
 */
public class FormatterMain {
    private Formatter formatter;
    private MyReader reader;
    private MyWriter writer;

    final static Logger logger =  LoggerFactory.getLogger(FormatterMain.class);

    /**
     * Streams
     * @param readFileName read filename
     * @param writeFileName write filename
     * @throws FormatterException will throw when bad things happened
     */
    public FormatterMain(final String readFileName, final String writeFileName) throws FormatterException {
        try {
            reader = new MyReader(new FileInputStream(readFileName));
            writer = new MyWriter(new PrintWriter(new OutputStreamWriter(new FileOutputStream(writeFileName))));
        }
        catch (IOException e) {
            throw new FormatterException(e);
        }
        formatter = new Formatter();
    }

    /**
     * Format all file
     * @throws FormatterException
     */
    public void formatCode() throws FormatterException {
        try {
            while (!reader.checkEnd()) {
                char nextChar = reader.read();
                writer.write(formatter.format(nextChar));
            }
            writer.close();
            reader.close();
        }
        catch (MyWriterException e) {
            if(logger.isErrorEnabled()){
                logger.error("Writing error :" + e.getMessage());
            }
            throw new FormatterException(e);
        }
        catch (MyReaderException e) {
            if (logger.isErrorEnabled()) {
                logger.error("Reading error :" + e.getMessage());
                throw new FormatterException(e);
            }
        }
    }
}
