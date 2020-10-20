package by.tsvirko.task06.service.query;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.List;

//TODO: move to Command

public interface Query<Entity, EntityStorage> {
    List<Entity> query(EntityStorage storage) throws FindException, NoAuthorsException, BookStorageElementException;
}
