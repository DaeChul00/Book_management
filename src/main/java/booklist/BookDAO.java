package booklist;

import java.util.List;

public interface BookDAO {
	public int insert(Book book);
	public List<Book> findAll();
	public Book findById(int id);
	public int update(Book book);
}
