package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOH2 implements BookDAO{
	private Connection conn;
	
	public BookDAOH2() {
		try{
			Class.forName("org.h2.Driver");
			conn=DriverManager
					.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");
			System.out.println(conn);
		}catch (Exception e) {
			System.out.println("Connection 객체 생성 오류!!");
			e.printStackTrace();
		}
	}
	public BookDAOH2(Connection conn) {
        this.conn = conn;
    }
	@Override
	   public int insert(Book book) {
	      
	      String sql="INSERT INTO BOOK (isbn, title, author, publisher, publictiondate, price, content, bookimage, rating) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      try {
	         PreparedStatement ps = conn.prepareStatement(sql);
	           ps.setString(1, book.getIsbn());
	           ps.setString(2, book.getTitle());
	           ps.setString(3, book.getAuthor());
	           ps.setString(4, book.getPublisher());
	           ps.setString(5, book.getPublictiondate());
	           ps.setInt(6, book.getPrice());
	           ps.setString(7, book.getContent());
	           ps.setString(8, book.getBookimage());
	           ps.setFloat(9, book.getRating());
	         
	         int result=ps.executeUpdate();
	         ps.close();
	         return result;
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	      }   
	   }
	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOK ORDER BY ID DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	list.add(resultSetToBook(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

	}
	@Override
	   public Book findById(int id) {
	       String sql = "SELECT * FROM BOOK WHERE ID = ?";
	       
	       try (PreparedStatement ps = conn.prepareStatement(sql)) {
	           
	           ps.setInt(1, id);
	           ResultSet rs = ps.executeQuery();
	           
	           if (rs.next()) {
	               Book book = new Book();
	               
	               book.setId(rs.getInt("ID"));
	               book.setIsbn(rs.getString("ISBN"));
	               book.setTitle(rs.getString("TITLE"));
	               book.setAuthor(rs.getString("AUTHOR"));
	               book.setPublisher(rs.getString("PUBLISHER"));
	               book.setPublictiondate(rs.getString("PUBLICTIONDATE"));
	               book.setPrice(rs.getInt("PRICE"));
	               book.setBookimage(rs.getString("BOOKIMAGE"));
	               book.setContent(rs.getString("CONTENT"));
	               book.setRating(rs.getFloat("RATING"));
	                   
	               return book;
	           }
	           
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       
	       return null;
	   }
	@Override
	public int update(Book book) {
		String sql = "UPDATE BOOK SET " +
		            "ISBN=?, TITLE=?, AUTHOR=?, PUBLISHER=?, "+
		            "PUBLICTIONDATE=?, PRICE=?, CONTENT=?, "+
		            "BOOKIMAGE=?, RATING=? "+
		            "WHERE ID=?"; 
		      try(PreparedStatement ps = conn.prepareStatement(sql)) {
		         ps.setString(1, book.getIsbn());
		         ps.setString(2, book.getTitle());
		         ps.setString(3, book.getAuthor());
		         ps.setString(4, book.getPublisher());
		         ps.setString(5, book.getPublictiondate());
		         ps.setInt(6, book.getPrice());
		         ps.setString(7, book.getContent());
		         ps.setString(8, book.getBookimage());
		         ps.setFloat(9, book.getRating());
		         ps.setInt(10, book.getId());
		         
		         return ps.executeUpdate();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return 0;
	}
	
	
	private Book resultSetToBook(ResultSet rs){

    	try {
    		Book book = new Book();

    		book.setId(rs.getInt("ID"));
            book.setIsbn(rs.getString("ISBN"));
            book.setTitle(rs.getString("TITLE"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setPublisher(rs.getString("PUBLISHER"));
            book.setPublictiondate(rs.getString("PUBLICTIONDATE"));
            book.setPrice(rs.getInt("PRICE"));
            book.setContent(rs.getString("CONTENT"));
            book.setBookimage(rs.getString("BOOKIMAGE"));
            book.setRating(rs.getFloat("RATING"));
            
        return book;
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }
	
}	
