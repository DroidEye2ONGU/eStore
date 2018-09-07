import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.BookMapper;
import droideye.estore.pojo.Book;
import droideye.estore.pojo.BookSalesVolume;

public class BookTest {

    @Test
    public void queryBooksByCategoryId() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.queryBooksByCategoryId(1);

        for (Book b :
                books) {
            System.out.println(b);
        }
        sqlSession.close();

    }

    @Test
    public void queryRecommendedBooksByCategoryIdTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.queryRecommendedBooksByCategoryId(1);

        for (Book b :
                books) {
            System.out.println(b);
        }

        sqlSession.close();
    }

    @Test
    public void querySingleBookById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        for (int i = 1; i <= 21; i++) {
            Book book = bookMapper.querySingleBook(i);
            System.out.println(book);
        }

        sqlSession.close();
    }

    @Test
    public void queryBookSalesVolumeTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<BookSalesVolume> bookSalesVolumes = bookMapper.queryBookSalesVolume();

        for (BookSalesVolume b :
                bookSalesVolumes) {
            System.out.println(b);
        }

        sqlSession.close();
    }
}
