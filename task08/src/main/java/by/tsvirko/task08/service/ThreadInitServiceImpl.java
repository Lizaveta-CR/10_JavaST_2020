package by.tsvirko.task08.service;

import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ThreadInitServiceImpl implements InitService {
    private static final Logger logger = LogManager.getLogger(ThreadInitServiceImpl.class);

    @Override
    public Array init(String fileName, int m1, int m2) throws ServiceInitException, ArrayException {
        if (!new Validator().validate(m1, m2)) {
            throw new ServiceInitException("Wrong parameters");
        }
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource("data").toURI();
        } catch (URISyntaxException e) {
            logger.info("no such uri", e.getMessage());
        }
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath, fileName);
        Scanner input = null;
        try {
            input = new Scanner(new BufferedReader(new FileReader(String.valueOf(path))));
        } catch (FileNotFoundException e) {
            logger.info("No such file exception");
            throw new ServiceInitException("No such file");
        }
        int threadAmount = 0;

        if (m1 > m2) {
            threadAmount = m2 + (int) (Math.random() * ((m1 - m2) + 1));
        } else if (m1 < m2) {
            threadAmount = m1 + (int) (Math.random() * ((m2 - m1) + 1));
        } else {
            threadAmount = m1;
        }
        Array array = new Array(threadAmount);
        try {
            try {
                String[] line = input.nextLine().trim().split(" ");
                for (int i = 0; i < array.getLength(); i++) {
                    array.setElement(i, Integer.parseInt(line[i]));
                }
            } catch (NoSuchElementException e) {
            }
        } catch (
                ArrayIndexOutOfBoundsException e) {
            throw new ServiceInitException("Too big input values");
        }
        return array;
    }
}
