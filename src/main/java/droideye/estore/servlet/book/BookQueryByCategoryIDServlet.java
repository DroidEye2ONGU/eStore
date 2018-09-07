package droideye.estore.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.Book;
import droideye.estore.pojo.Category;
import droideye.estore.service.BookService;
import droideye.estore.service.CategoryService;
import droideye.estore.service.Impl.BookServiceImpl;
import droideye.estore.service.Impl.CategoryServiceImpl;

@WebServlet(name = "BookQueryByCategoryIDServlet", urlPatterns = "/BookQueryByCategoryIDServlet")
public class BookQueryByCategoryIDServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BookService bookService = new BookServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        String categoryId = request.getParameter("id");
        List<Book> books = bookService.queryBooksByCategoryId(categoryId);

        Category category = categoryService.querySingleCategoryById(categoryId);

        request.setAttribute("books",books);
        request.setAttribute("category",category);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
