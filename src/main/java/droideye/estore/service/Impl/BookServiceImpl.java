package droideye.estore.service.Impl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.BookMapper;
import droideye.estore.pojo.Book;
import droideye.estore.pojo.BookSalesVolume;
import droideye.estore.service.BookService;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> queryBooksByCategoryId(String categoryId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.queryBooksByCategoryId(Integer.parseInt(categoryId));

        sqlSession.close();
        return books;
    }

    @Override
    public List<Book> queryRecommendedBooksByCategoryId(String categoryId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> recommendedBooks = bookMapper.queryRecommendedBooksByCategoryId(Integer.parseInt(categoryId));

        sqlSession.close();
        return recommendedBooks;
    }

    @Override
    public Book querySingleBookById(String id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        Book book = bookMapper.querySingleBook(Integer.parseInt(id));

        sqlSession.close();

        return book;
    }

    @Override
    public List<BookSalesVolume> queryBookSalesVolume() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<BookSalesVolume> bookSalesVolumes = bookMapper.queryBookSalesVolume();

        sqlSession.close();

        return bookSalesVolumes;
    }

    @Override
    public List<Book> queryAllRecommendedBooks() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.queryAllRecommendedBooks();

        sqlSession.close();
        return books;
    }
}
