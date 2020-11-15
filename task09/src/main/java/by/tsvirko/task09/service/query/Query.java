package by.tsvirko.task09.service.query;


import java.util.List;

public interface Query<Entity> {
    Entity query(Entity entity);
}
