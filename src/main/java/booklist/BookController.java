package booklist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet("/books/*")
@MultipartConfig
public class BookController extends HttpServlet {

	BookService service = new BookService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String[] command = req.getRequestURI().split("/");
		switch (command[2]) {
		case "views":
			List<MainBook> list = service.getMainBook();

			req.setAttribute("list", list);

			req.getRequestDispatcher("/WEB-INF/views/book/views.jsp").forward(req, resp);
			break;
		case "view":
			int id = Integer.parseInt(req.getParameter("id"));
			Book book = service.getBook(id);
			req.setAttribute("book", book);
			req.getRequestDispatcher("/WEB-INF/views/book/view.jsp").forward(req, resp);
			break;

		case "insert":
			req.getRequestDispatcher("/WEB-INF/views/book/BookInsertForm.jsp").forward(req, resp);
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    req.setCharacterEncoding("UTF-8");

	    String isbn = req.getParameter("isbn");
	    String title = req.getParameter("title");
	    String author = req.getParameter("author");
	    String publisher = req.getParameter("publisher");
	    String publictionadate = req.getParameter("publictionadate");
	    String price = req.getParameter("price");
	    String content = req.getParameter("content");
	    String bookimage = req.getParameter("bookimage");

	    float rating = 0;
	    String ratingStr = req.getParameter("rating");
	    if(ratingStr != null && !ratingStr.isEmpty()){
	        rating = Float.parseFloat(ratingStr);
	    }

	    service.insert(isbn, title, author, publisher, publictionadate, price, content, bookimage, rating);

	    resp.sendRedirect(req.getContextPath() + "/books/views");
	}

}
