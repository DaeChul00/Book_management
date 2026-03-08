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
	public boolean insert(String isbn, String title, String author, String publisher, String publictionadate, int price,
			String content, String bookimage, float rating) {
		Book book = new Book(isbn, title, author, publisher, publictionadate, price, content, bookimage, rating);
		int result = dao.insert(book);
		return result > 0;
	}
	public void updateBook(Book book) {
		dao.update(book);
	}
}
