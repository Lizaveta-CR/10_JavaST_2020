package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {
    private final String FILE_PATH = "Books";
    private static final Logger logger = LogManager.getLogger(BookDaoImpl.class);

    /**
     * Writes(creates) book in file
     *
     * @param book
     * @throws DaoStorageException
     */
    @Override
    public void create(Book book) throws DaoStorageException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_PATH), true);

            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(book);

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
     * @param book
     * @throws DaoStorageException
     */
    @Override
    public void delete(Book book) throws DaoStorageException {
        List<Book> books = null;
        try {
            books = readAll();
        } catch (IOException e) {
            throw new DaoStorageException(e.getMessage());
        }

        books.remove(book);
        logger.info("Book was removed from file");
        File f = new File(FILE_PATH);
        f.delete();
        for (Book b : books) {
            try {
                create(b);
            } catch (DaoStorageException e) {
                logger.info("DAO exception: " + e.getMessage());
                throw new DaoStorageException("Can not create books");
            }
        }
    }

    /**
     * Reads book from file
     *
     * @param book
     * @return
     * @throws DaoStorageException
     */
    @Override
    public Book read(Book book) throws DaoStorageException {
        Book resultBook = null;
        try {
            List<Book> books = readAll();
            for (int i = 0; i < books.size(); i++) {
                if (book.equals(books.get(i))) {
                    resultBook = books.get(i);
                    break;
                }
            }
            logger.info("Book was read from file");
        } catch (IOException e) {
            logger.info("DAO read(Book book) exception: " + e.getMessage());
            throw new DaoStorageException("No such book");
        }
        return resultBook;
    }

    /**
     * Reads all books from file. Only for BookDAO class use!
     *
     * @return
     * @throws IOException
     */
    private List<Book> readAll() throws IOException {
        List<Book> books = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(FILE_PATH));
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                books.add((Book) ois.readObject());
            }
        } catch (EOFException | ClassNotFoundException e) {
        } finally {
            if (fis != null)
                fis.close();
        }
        return books;
    }
}
