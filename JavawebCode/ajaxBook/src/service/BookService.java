package service;

import entity.Book;
import entity.Page;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book queryBook(int id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> getBooksByPageAndPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
