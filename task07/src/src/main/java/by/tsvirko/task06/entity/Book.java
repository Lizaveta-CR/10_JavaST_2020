package by.tsvirko.task06.entity;

import by.tsvirko.task06.entity.exception.NoAuthorsException;

import java.io.Serializable;
import java.util.*;

public class Book extends Publication implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<String> authors = new TreeSet<>();
    private int yearOfPublishing;

    public Book() {
    }

    public Book(String title, Set<String> authors, int numberOfPages, String publishingHouse, int yearOfPublishing) {
        super(title, numberOfPages, publishingHouse);
        this.authors = authors;
        this.yearOfPublishing = yearOfPublishing;
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

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authors, yearOfPublishing);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + getNumberOfPages() +
                ", publishingHouse='" + getPublishingHouse() + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
