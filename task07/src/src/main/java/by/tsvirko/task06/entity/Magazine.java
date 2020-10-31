package by.tsvirko.task06.entity;

import java.util.Objects;

public class Magazine extends Publication {
    private String coverHeading;

    public Magazine() {
    }

    public Magazine(String title, int numOfPages, int year, String coverHeading, String publishingHouse) {
        super(title, numOfPages, year, publishingHouse);
        this.coverHeading = coverHeading;
    }

    public String getCoverHeading() {
        return coverHeading;
    }

    public void setCoverHeading(String coverHeading) {
        this.coverHeading = coverHeading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(coverHeading, magazine.coverHeading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coverHeading);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", numOfPages=" + getNumberOfPages() +
                ", year=" + getYear() +
                ", coverHeading='" + coverHeading + '\'' +
                ", publishingHouse='" + getPublishingHouse() + '\'' +
                '}';
    }
}
