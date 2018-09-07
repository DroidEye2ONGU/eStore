package droideye.estore.mapper;

import java.util.List;

import droideye.estore.pojo.Book;
import droideye.estore.pojo.BookSalesVolume;

public interface BookMapper {

    /*
    * 根据类别号找到该类别下的所有书籍
    * */

    public List<Book> queryBooksByCategoryId(Integer categoryId);


    /*
     * 根据类别号获取到该类下的推荐书籍
     * */
    public List<Book> queryRecommendedBooksByCategoryId(Integer categoryId);

    /*
     * 根据ID号获取该书籍
     * */
    public Book querySingleBook(Integer id);

    /*
     * 查找书籍的销量,销量从高到低排序
     * */
    public List<BookSalesVolume> queryBookSalesVolume();

    /*
     * 读取所有推荐书籍
     * */
    public List<Book> queryAllRecommendedBooks();
}


