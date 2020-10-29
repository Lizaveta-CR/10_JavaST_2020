package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.PublicationDao;
import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;


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
        } catch (DaoStorageException e) {
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
                throw new DaoStorageException("Can not create publication in file");
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
        } catch (DaoStorageException e) {
            logger.info("DAO read(Publication publ) exception: " + e.getMessage());
            throw new DaoStorageException("No such publ");
        }
        return resultBook;
    }

    /**
     * Updates publicationOld with publicationNew in storage
     *
     * @param publicationOld,publicationNew
     */
    @Override
    public void update(Publication publicationOld, Publication publicationNew) throws DaoStorageException {
        delete(publicationOld);
        create(publicationNew);
    }

    @Override
    public void createRandom() throws DaoStorageException {
        Set<String> harry = new HashSet<>();
        harry.add("J.K.Rowling");
        Publication book = new Book("sls", harry, 10000, "USA House", 2000);
        Set<String> warAndPiece = new HashSet<>();
        warAndPiece.add("Tolstoy");
        Publication book1 = new Book("War and piece", warAndPiece, 1225, "unknown", 1865);
        Set<String> q = new HashSet<>();
        q.add("q");
        Publication book2 = new Book("q", q, 1, "q", 1);
        Publication magazine1 = new Magazine("Vogue", 123, "gloss", "q");
        Publication magazine2 = new Magazine("Bazar", 123, "gloss", "w");
        try {
            create(book);
            create(book1);
            create(book2);
            create(magazine1);
            create(magazine2);
        } catch (DaoStorageException e) {
            throw new DaoStorageException("Can not save publications to file");
        }
    }

    /**
     * Reads all books from file
     *
     * @return
     * @throws IOException
     */
    public List<Publication> readAll() throws DaoStorageException {
        List<Publication> books = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(FILE_PATH));
            while (true) {
                ois = new ObjectInputStream(fis);
                books.add((Publication) ois.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new DaoStorageException("Can't read file information");
                }
            }
        }
        return books;
    }

    public static void main(String[] args) throws DaoStorageException {

        PublicationDaoImpl publicationDao = new PublicationDaoImpl();
        publicationDao.createRandom();
        for (Publication publication : publicationDao.readAll()) {
            System.out.println(publication);
        }
    }
}
