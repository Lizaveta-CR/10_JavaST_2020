package by.tsvirko.task06.entity;

import by.tsvirko.task06.entity.exception.NoAuthorsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private Set<String> authors;
    private int numberOfPages;
    private String publishingHouse;
    private int yearOfPublishing;

    public Book(String title, Set<String> authors, int numberOfPages, String publishingHouse, int yearOfPublishing) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(int i) throws NoAuthorsException {
        if (authors.isEmpty()) {
            throw new NoAuthorsException();
        }
        return new ArrayList<>(authors).get(i);
    }

    public void setAuthor(String author) {
        authors.add(author);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
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
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages &&
                yearOfPublishing == book.yearOfPublishing &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publishingHouse, book.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, numberOfPages, publishingHouse, yearOfPublishing);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
