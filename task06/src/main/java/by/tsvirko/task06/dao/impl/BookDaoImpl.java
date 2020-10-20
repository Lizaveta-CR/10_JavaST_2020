package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.service.query.Query;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {
    private final String FILE_PATH = "Books";

    @Override
    public void create(Book book) throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_PATH), true);

            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(book);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file does not exist");
        } catch (IOException e) {
            throw new IOException("Error initializing stream");
        }
    }

    @Override
    public void delete(Book book) throws IOException {
        List<Book> books = readAll();

        books.remove(book);

        File f = new File(FILE_PATH);
        f.delete();
        for (Book b : books) {
            create(b);
        }
//        if (f.delete()) - logger(success or not)
    }

    @Override
    public Book read(Book book) throws BookStorageElementException, IOException {
        List<Book> books = readAll();
        for (int i = 0; i < books.size(); i++) {
            if (book.equals(books.get(i))) {
                return books.get(i);
            }
        }
        throw new BookStorageElementException("No such book");
    }

    @Override
    public List<Book> readAll() throws IOException {
        List<Book> books = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(FILE_PATH));
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                books.add((Book) ois.readObject());
            }
        } catch (EOFException | ClassNotFoundException ignored) {
        } finally {
            if (fis != null)
                fis.close();
        }
        return books;
    }
}
