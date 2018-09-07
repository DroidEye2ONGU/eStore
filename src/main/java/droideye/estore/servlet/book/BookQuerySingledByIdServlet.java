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

@WebServlet(name = "BookQuerySingledByIdServlet", urlPatterns = "/BookQuerySingledByIdServlet")
public class BookQuerySingledByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String id = request.getParameter("id");
        String categoryId = request.getParameter("categoryid");

        BookService bookService = new BookServiceImpl();
        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        Book book = bookService.querySingleBookById(id);
        Category category = categoryService.querySingleCategoryById(categoryId);

        request.setAttribute("book",book);
        request.setAttribute("categoryname",category.getName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home/book.jsp");
        requestDispatcher.forward(request,response);
    }
}
