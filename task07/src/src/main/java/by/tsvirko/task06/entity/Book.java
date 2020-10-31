package by.tsvirko.task06.entity;

import by.tsvirko.task06.entity.exception.NoAuthorsException;

import java.io.Serializable;
import java.util.*;

public class Book extends Publication {

    private Set<String> authors = new TreeSet<>();

    public Book() {
    }

    public Book(String title, int numberOfPages, int yearOfPublishing, String publishingHouse, Set<String> authors) {
        super(title, numberOfPages, yearOfPublishing, publishingHouse);
        this.authors = authors;
    }

    public String getAuthor(int i) throws NoAuthorsException {
        if (authors.isEmpty()) {
            throw new NoAuthorsException();
        }
        return new ArrayList<>(authors).get(i);
    }

    public int getAuthorsSize() {
        return authors.size();
    }

    public void setAuthor(String author) {
        authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title=" + getTitle() + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + getNumberOfPages() +
                ", publishingHouse='" + getPublishingHouse() + '\'' +
                ", yearOfPublishing=" + getYear() +
                '}';
    }
}
