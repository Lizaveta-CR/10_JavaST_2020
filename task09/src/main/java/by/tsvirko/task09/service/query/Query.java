package by.tsvirko.task09.service.query;


import java.util.List;

public interface Query<Entity,Storage> {
    Entity query(Storage storage);
}
