package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.service.BookFieldsService;

import java.lang.reflect.Field;

public class BookFieldsServiceImpl implements BookFieldsService {
    @Override
    public StringBuilder getBookFields() {
        StringBuilder sb = new StringBuilder();

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
