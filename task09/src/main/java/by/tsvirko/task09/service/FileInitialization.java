package by.tsvirko.task09.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInitialization {
    private static final Logger logger = LogManager.getLogger(FileInitialization.class);

    private String filename;

    public FileInitialization(String filename) {
        this.filename = filename;
    }

    public String initialize() {
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource("data").toURI();
        } catch (URISyntaxException e) {
            logger.info("no such uri", e.getMessage());
        }
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath, filename);

        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(String.valueOf(path));
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            logger.debug("No such file " + filename);
        } catch (IOException e) {
            logger.debug("IOException " + e.getMessage());
        }
        return text;
    }
}
