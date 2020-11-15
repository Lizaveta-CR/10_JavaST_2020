package by.tsvirko.task09.repository;

import by.tsvirko.task09.entity.TextStorage;
import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.query.Query;

public class TextStorageRepositoryImpl implements TextStorageRepository {
    private TextStorage storage = TextStorage.getInstance();

    @Override
    public void setComponent(Component component) {
        storage.setComponent(component);
    }

    @Override
    public Component getComponent(int childIndex) {
        return storage.getComponent(childIndex);
    }

    @Override
    public Composite query(Query<Composite, TextStorage> compositeQuery) {
        return compositeQuery.query(storage);
    }
}
