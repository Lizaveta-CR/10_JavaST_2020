package main.java.by.tsvirko.service;

import main.java.by.tsvirko.service.exception.FileOpeningException;

public interface FileReading {
    String read(String fileName) throws FileOpeningException;
}
