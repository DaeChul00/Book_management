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
	
	BookService service;
	
	public BookController() {
		service=new BookService();
	}
	//
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
		case "insert":
			req.getRequestDispatcher("/WEB-INF/views/book/insert.jsp").forward(req, resp);
			break;
		case "update":
		    id = Integer.parseInt(req.getParameter("id"));
		    book = service.getBook(id);
		    req.setAttribute("book", book);
		    req.getRequestDispatcher("/WEB-INF/views/book/update.jsp").forward(req, resp);
		    break;
		default:
			break;
		}
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");

		    String[] command = req.getRequestURI().split("/");

		    switch(command[2]) {
		    
		    case "insert":
		    	req.setCharacterEncoding("UTF-8");
		    	String isbn = req.getParameter("isbn");
		    	String title = req.getParameter("title");
		    	String author = req.getParameter("author");
		    	String publisher = req.getParameter("publisher");
		    	String publictionadate = req.getParameter("publictionadate");
		    	int price = Integer.parseInt(req.getParameter("price"));
		    	String content = req.getParameter("content");
		    	String bookimage = req.getParameter("bookimage");
		    	
		    	float rating = 0;
		    	String ratingStr = req.getParameter("rating");
		    	if(ratingStr != null && !ratingStr.isEmpty()){
		    		rating = Float.parseFloat(ratingStr);
		    	}
		    	
		    	service.insert(isbn, title, author, publisher, publictionadate, price, content, bookimage, rating);
		    	
		    	resp.sendRedirect(req.getContextPath() + "/books/views");
		    	break;
		    	
		    case "update":
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

		        service.updateBook(book);

		        resp.sendRedirect(req.getContextPath() + "/books/views");
		        break;
		    } 
		}
}
