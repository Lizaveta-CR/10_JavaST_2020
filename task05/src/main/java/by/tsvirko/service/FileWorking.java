package main.java.by.tsvirko.service;

import main.java.by.tsvirko.service.exception.FileOpeningException;

import java.io.IOException;


public interface FileWorking {
    String read(String fileName) throws FileOpeningException;

    void write(String fileName, String text) throws IOException;
}
