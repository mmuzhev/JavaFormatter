package com.mmuzhev.main;

import com.mmuzhev.formatter.FormatterException;
import com.mmuzhev.reader.ReaderException;
import com.mmuzhev.runner.Runner;
import com.mmuzhev.runner.RunnerException;
import com.mmuzhev.writer.WriterException;

/*
Expected that code writed correct, else program will not work at all
 */
public class Main {
    public static void main (String[] args) throws ReaderException, WriterException, RunnerException, FormatterException{
        Runner runner = new Runner("in.txt", "out.txt");
        runner.formatCode();
    }
}
