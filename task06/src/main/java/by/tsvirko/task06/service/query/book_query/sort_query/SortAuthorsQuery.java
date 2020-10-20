package by.tsvirko.task06.service.query.book_query.sort_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;

import java.util.ArrayList;
import java.util.List;

public class SortAuthorsQuery extends AbstractSortQuery {
    @Override
    public List<Book> query(BookStorage storage) {
        List<Book> result = new ArrayList<>();
//TODO:
//        Comparator<Book> comparatorBook = null;
//        for (int i = 0; i < storage.size(); i++) {
//            Book book = storage.get(i);
//            List<String> authors = new ArrayList<>();
//            for (int j = 0; j < book.getAuthorsSize(); j++) {
//                authors.add(book.getAuthor(i));
//            }
//            Collections.sort(authors);
//        }
////
//        if (isDescending()) {
//            comparator = comparator.reversed();
//        }
//        result.sort(comparator);
        return result;
    }
}
