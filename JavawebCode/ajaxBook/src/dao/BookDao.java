package dao;

import entity.Book;
import entity.Page;

import java.util.List;

public interface BookDao {

    //新增book
    int addBook(Book book);

    //根据id删除book
    int deleteBookById(Integer id);

    //修改book信息
    int updateBook(Book book);

    //根据id查询book信息
    Book queryBookById(Integer id);

    //查询所有book信息
    List<Book> queryBooks();

    //查询总记录数
    int queryForTotalCount();

    //查询当前页面数据
    List<Book> queryForPageItems(int begin, int pageSize);

    int queryForTotalCountByPrice(int min, int max);

    List<Book> queryForBooksByPrice(int begin ,int pageSize, int min, int max);

}
