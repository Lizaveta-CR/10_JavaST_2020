package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.BookFieldsService;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Set;

public class BookFieldsServiceImpl implements BookFieldsService {
    @Override
    public StringBuilder getBookFields() throws BookStorageElementException {
        StringBuilder sb = new StringBuilder();
        RepositoryFactory factory = RepositoryFactory.getInstance();
        BookRepository bookRepository = factory.getBookRepository();

        Field[] declaredFields = new Book().getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (!name.equals("serialVersionUID")) {
                sb.append(name + " ");
            }
        }
        return sb;
    }
}
