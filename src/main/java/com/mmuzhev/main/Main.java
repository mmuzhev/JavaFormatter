package com.mmuzhev.main;

import com.mmuzhev.formatter.FormatterException;
import com.mmuzhev.formatter.FormatterMain;
import com.mmuzhev.reader.MyReaderException;
import com.mmuzhev.writer.MyWriterException;

import java.io.*;

public class Main {
    public static void main (String[] args) throws MyReaderException, MyWriterException, FormatterException{

        FormatterMain formatterMain = new FormatterMain("in.txt", "out.txt");
        formatterMain.formatCode();
    }
}
