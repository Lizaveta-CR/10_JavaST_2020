package by.tsvirko.task09.service;

import by.tsvirko.task09.service.query.exception.FileServiceException;
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

    public FileInitialization() {
    }

    public String initialize() throws FileServiceException {
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource("data").toURI();
        } catch (URISyntaxException e) {
            logger.info("no such uri", e.getMessage());
            throw new FileServiceException(e.getMessage());
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
            throw new FileServiceException(e.getMessage());
        } catch (IOException e) {
            logger.debug("IOException " + e.getMessage());
            throw new FileServiceException(e.getMessage());
        }
        logger.info("File " + filename + "was initialized");

        if (text.isEmpty()) {
            throw new FileServiceException("Write information into file!");
        }
        return text;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
