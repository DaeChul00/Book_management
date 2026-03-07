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
		case "modify":
		    int modId = Integer.parseInt(req.getParameter("id"));
		    Book modBook = service.getBook(modId);
		    req.setAttribute("book", modBook);
		    req.getRequestDispatcher("/WEB-INF/views/book/modify.jsp").forward(req, resp);
		    break;

			
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    String uri = req.getRequestURI();
	    
	    if (uri.contains("update")) {
	        Book book = new Book();
	        book.setId(Integer.parseInt(req.getParameter("id")));
	        book.setIsbn(req.getParameter("isbn"));
	        book.setTitle(req.getParameter("title"));
	        book.setAuthor(req.getParameter("author"));
	        book.setPublisher(req.getParameter("publisher"));
	        book.setPublictiondate(req.getParameter("publictiondate"));
	        book.setPrice(Integer.parseInt(req.getParameter("price")));
	        book.setContent(req.getParameter("content"));
	        book.setBookimage(req.getParameter("bookimage"));
	        book.setRating(Float.parseFloat(req.getParameter("rating")));

	        // BookService에 update 메서드가 있어야 함
	        service.updateBook(book); 
	        
	        // 수정 후 상세보기 페이지로 이동
	        resp.sendRedirect(req.getContextPath() + "/books/views");
	    }
	}
	   

}
