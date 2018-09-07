package droideye.estore.servlet.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.Book;
import droideye.estore.pojo.BookSalesVolume;
import droideye.estore.pojo.Category;
import droideye.estore.service.BookService;
import droideye.estore.service.CategoryService;
import droideye.estore.service.Impl.BookServiceImpl;
import droideye.estore.service.Impl.CategoryServiceImpl;

@WebServlet(name = "IndexPageServlet", urlPatterns = "/IndexPageServlet")
public class IndexPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取图书类别服务类
        CategoryService categoryService = new CategoryServiceImpl();
        //获取所有的图书类别
        List<Category> categories = categoryService.getAllCategories();

        //获取图书服务类
        BookService bookService = new BookServiceImpl();
        //遍历所有的图书类别,获取每个类别推荐的两本书,存储在Map中
        Map<Integer, List<Book>> recommendedBooksMap = new HashMap<>();
        for (Category c :
                categories) {
            List<Book> recommendedBooks = bookService.queryRecommendedBooksByCategoryId(c.getId() + "");
            recommendedBooksMap.put(c.getId(), recommendedBooks);
        }

        //获取每个书的销量,将排名前三的书的集合存入request域中
        List<BookSalesVolume> bookSalesVolumes = bookService.queryBookSalesVolume();
        List<Book> mostSalesBooks = new ArrayList<>();
        for (int i = 0; i < 3 && i < bookSalesVolumes.size(); i++) {
            Integer bookId = bookSalesVolumes.get(i).getBookId();
            mostSalesBooks.add(bookService.querySingleBookById(bookId + ""));
        }

        //读取所有推荐书籍
        List<Book> recommendedBooks = bookService.queryAllRecommendedBooks();

        getServletContext().setAttribute("mostsalesbooks",mostSalesBooks);
        getServletContext().setAttribute("categories", categories);
        getServletContext().setAttribute("recommendedBooksMap",recommendedBooksMap);
        getServletContext().setAttribute("recommendedBooks", recommendedBooks);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
