package by.tsvirko.task06.entity;

import java.io.Serializable;
import java.util.Objects;

public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private int numberOfPages;
    private int year;
    private String publishingHouse;

    public Publication() {
    }

    public Publication(String title, int numberOfPages, int year, String publishingHouse) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.year = year;
        this.publishingHouse = publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return numberOfPages == that.numberOfPages &&
                year == that.year &&
                Objects.equals(title, that.title) &&
                Objects.equals(publishingHouse, that.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages, year, publishingHouse);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", year=" + year +
                ", publishingHouse='" + publishingHouse + '\'' +
                '}';
    }
}
