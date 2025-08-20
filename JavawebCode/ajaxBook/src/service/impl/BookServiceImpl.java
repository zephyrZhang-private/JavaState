package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import entity.Page;
import service.BookService;
import utils.EntityUtils;

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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //获取总记录数
        int totalCount = bookDao.queryForTotalCount();
        page.setTotalCount(totalCount);
        //获取总页数
        int totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            totalPage++;
        }
        page.setTotalPage(totalPage);
        //获取当前页码
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //获取当前页面数据
        List<Book> items = bookDao.queryForPageItems((page.getPageNo() - 1) * pageSize, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> getBooksByPageAndPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        //查询对应价格区间商品信息总记录数
        Integer totalCount = bookDao.queryForTotalCountByPrice(min, max);
        page.setTotalCount(totalCount);
        //总页数
        Integer totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            totalPage += 1;
        }
        page.setTotalPage(totalPage);

        //因为模型类中有设计,判断页码是否合法,还设置了最大页码,是与参数totalPage判断
        //此时未传入totalPage,先传入pageNo会导致totalPage的空指针异常
        page.setPageNo(pageNo);
        //查询当前页码数据
        Integer begin = (pageNo - 1) * pageSize;
        //通过价格区间分页查询当前页面的数据
        List<Book> bookList = this.bookDao.queryForBooksByPrice(begin, pageSize, min, max);
        page.setItems(bookList);
        return page;
    }
}
