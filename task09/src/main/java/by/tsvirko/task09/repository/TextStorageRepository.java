package by.tsvirko.task09.repository;

import by.tsvirko.task09.entity.TextStorage;
import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.query.Query;

public interface TextStorageRepository {
    void setComponent(Component component);

    Component getComponent(int childIndex);

    Composite query(Query<Composite, TextStorage> query);
}
