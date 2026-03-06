package booklist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books/*")
public class BookController extends HttpServlet {
	
	BookService service = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String[] command = req.getRequestURI().split("/");
		switch(command[2]) {
		case "views":
			List<MainBook> list=service.getMainBook();
			
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("/WEB-INF/views/book/views.jsp").forward(req, resp);
			break;
		case "view":
			int id=Integer.parseInt(req.getParameter("id"));
			Book book=service.getBook(id);
			req.setAttribute("book",book);
			req.getRequestDispatcher("/WEB-INF/views/book/view.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}

}
