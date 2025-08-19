package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import service.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBook(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
