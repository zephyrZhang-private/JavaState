package service;

import entity.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book queryBook(int id);

    List<Book> queryBooks();
}
