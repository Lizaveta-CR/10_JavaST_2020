package by.tsvirko.task06.repository.query;


import by.tsvirko.task06.dao.exception.BookStorageElementException;

import java.util.List;

//TODO: move to Command

public interface Query<Entity, EntityStorage> {
    List<Entity> query(EntityStorage storage) throws BookStorageElementException;
}
