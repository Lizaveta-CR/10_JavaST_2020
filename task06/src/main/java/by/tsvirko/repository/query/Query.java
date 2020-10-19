package by.tsvirko.repository.query;


import by.tsvirko.dao.exception.BookStorageElementException;

import java.util.List;

//TODO: move to Command

public interface Query<Entity, EntityStorage> {
    List<Entity> query(EntityStorage storage) throws BookStorageElementException;
}
