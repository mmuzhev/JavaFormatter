package com.mmuzhev.runner;

import com.mmuzhev.formatter.Formatter;
import com.mmuzhev.reader.Reader;
import com.mmuzhev.reader.ReaderException;
import com.mmuzhev.writer.Writer;
import com.mmuzhev.writer.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Formatting process
 */
public class Runner {
        private Formatter formatter;
        private Reader reader;
        private Writer writer;

        final static Logger logger =  LoggerFactory.getLogger(com.mmuzhev.runner.Runner.class);

        /**
         * Streams
         * @param readFileName read filename
         * @param writeFileName write filename
         * @throws RunnerException will throw when bad things happened
         */
        public Runner(final String readFileName, final String writeFileName) throws RunnerException {
            try {
                reader = new Reader(new FileInputStream(readFileName));
                writer = new Writer(new PrintWriter(new OutputStreamWriter(new FileOutputStream(writeFileName))));
            }
            catch (IOException e) {
                throw new RunnerException(e);
            }
            formatter = new Formatter();
        }

        /**
         * Format all file
         * @throws RunnerException
         */
        public void formatCode() throws RunnerException {
            try {
                while (!reader.checkEnd()) {
                    char nextChar = reader.read();
                    writer.write(formatter.format(nextChar));
                }
                writer.close();
                reader.close();
            }
            catch (WriterException e) {
                if(logger.isErrorEnabled()){
                    logger.error("Writing error :" + e.getMessage());
                }
                throw new RunnerException(e);
            }
            catch (ReaderException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("Reading error :" + e.getMessage());
                    throw new RunnerException(e);
                }
            }
        }
    }
