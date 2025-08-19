package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import org.junit.Test;
import utils.EntityUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBookDao {

    BookDao bookDao = new BookDaoImpl();
    @Test
    public void test01(){
        Map<String,Object> map = new HashMap<>();
        Book book = new Book();
        map.put("id",null);
        map.put("name","少年阿宾");
        map.put("price",new BigDecimal(199));
        map.put("author","黄少");
        map.put("sales",2000);
        map.put("stock",299);
        map.put("img_path","static/img/aBin.png");
        EntityUtils.copyParamToBean(map,book);
        bookDao.addBook(book);


        /*Book book = new Book(null,"少年阿宾",new BigDecimal(199),"黄少",2000,200,"static/img/aBin.png");
        bookDao.addBook(book);*/
    }

    @Test
    public void test02(){
        bookDao.deleteBookById(52);
    }

    @Test
    public void test03(){
        Book book = new Book(51,"少年阿宾",new BigDecimal(199),"黄少",2000,200,"static/img/aBin.png");
        bookDao.updateBook(book);
    }

    @Test
    public void test04(){
        System.out.println(bookDao.queryBookById(15));
    }

    @Test
    public void test05(){
        List<Book> list = bookDao.queryBooks();
        for(Book book:list){
            System.out.println(book);
        }
    }
}
