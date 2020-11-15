package by.tsvirko.task09.repository;

public class RepositoryFactory {
    private static RepositoryFactory instance = new RepositoryFactory();
    private TextStorageRepository textStorageRepository = new TextStorageRepositoryImpl();

    public static RepositoryFactory getInstance() {
        return instance;
    }

    public TextStorageRepository getTextStorageRepository() {
        return textStorageRepository;
    }
}
