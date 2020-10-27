package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.PublicationDao;
import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Publication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PublicationDaoImpl implements PublicationDao {
    private final String FILE_PATH = "Books";
    private static final Logger logger = LogManager.getLogger(PublicationDaoImpl.class);

    /**
     * Writes(creates) book in file
     *
     * @param publication
     * @throws DaoStorageException
     */
    @Override
    public void create(Publication publication) throws DaoStorageException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_PATH), true);

            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(publication);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            logger.info("DAO fileNotFoundException occurred");
            throw new DaoStorageException("File storage does not exist");
        } catch (IOException e) {
            logger.info("DAO IOException occurred");
            throw new DaoStorageException("Error initializing stream");
        }
    }

    /**
     * Deletes book from file
     *
     * @param publication
     * @throws DaoStorageException
     */
    @Override
    public void delete(Publication publication) throws DaoStorageException {
        List<Publication> books = null;
        try {
            books = readAll();
        } catch (IOException e) {
            throw new DaoStorageException(e.getMessage());
        }

        books.remove(publication);
        logger.info("Publication was removed from file");
        File f = new File(FILE_PATH);
        f.delete();
        for (Publication b : books) {
            try {
                create(b);
            } catch (DaoStorageException e) {
                logger.info("DAO exception: " + e.getMessage());
                throw new DaoStorageException("Can not create publication");
            }
        }
    }

    /**
     * Reads book from file
     *
     * @param publication
     * @return
     * @throws DaoStorageException
     */
    @Override
    public Publication read(Publication publication) throws DaoStorageException {
        Publication resultBook = null;
        try {
            List<Publication> books = readAll();
            for (int i = 0; i < books.size(); i++) {
                if (publication.equals(books.get(i))) {
                    resultBook = books.get(i);
                    break;
                }
            }
            logger.info("Publication was read from file");
        } catch (IOException e) {
            logger.info("DAO read(Publication publ) exception: " + e.getMessage());
            throw new DaoStorageException("No such publ");
        }
        return resultBook;
    }

    /**
     * Reads all books from file. Only for BookDAO class use!
     *
     * @return
     * @throws IOException
     */
    private List<Publication> readAll() throws IOException {
        List<Publication> books = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(FILE_PATH));
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                books.add((Publication) ois.readObject());
            }
        } catch (EOFException | ClassNotFoundException e) {
        } finally {
            if (fis != null)
                fis.close();
        }
        return books;
    }
}
