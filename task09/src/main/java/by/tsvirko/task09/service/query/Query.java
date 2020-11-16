package by.tsvirko.task09.service.query;


public interface Query<Entity,Storage> {
    Entity query(Storage storage);
}
