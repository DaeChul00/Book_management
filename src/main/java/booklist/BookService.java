package booklist;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	
	private BookDAO dao;
	
	public BookService() {
		dao = new BookDAOH2();
	}
	public List<MainBook> getMainBook(){
		List<Book> books = dao.findAll();
		List<MainBook> list = new ArrayList<MainBook>();
		for(Book b:books) {
			list.add(new MainBook(
		            b.getId(), 
		            b.getBookimage(), 
		            b.getTitle(), 
		            b.getAuthor(), 
		            b.getPublisher(), 
		            b.getPublictiondate(), 
		            b.getPrice(), 
		            b.getContent(), 
		            b.getRating()
		        ));
		}
		return list;
	}
	public Book getBook(int id) {
		return dao.findById(id);
	}
	public void updateBook(Book book) {
		dao.update(book);
	}
}
