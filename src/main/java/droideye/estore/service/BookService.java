package droideye.estore.service;

import java.util.List;

import droideye.estore.pojo.Book;
import droideye.estore.pojo.BookSalesVolume;

public interface BookService {

    public List<Book> queryBooksByCategoryId(String categoryId);

    public List<Book> queryRecommendedBooksByCategoryId(String categoryId);

    public Book querySingleBookById(String id);

    public List<BookSalesVolume> queryBookSalesVolume();

    public List<Book> queryAllRecommendedBooks();
}
