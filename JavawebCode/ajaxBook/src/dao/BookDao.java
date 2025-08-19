package dao;

import entity.Book;

import java.util.List;

public interface BookDao {

    //新增book
    public int addBook(Book book);

    //根据id删除book
    public int deleteBookById(Integer id);

    //修改book信息
    public int updateBook(Book book);

    //根据id查询book信息
    public Book queryBookById(Integer id);

    //查询所有book信息
    public List<Book> queryBooks();
}
