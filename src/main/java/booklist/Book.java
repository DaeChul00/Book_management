package booklist;
//상세보기 페이지의 북 내용
public class Book {
	private int id;//데이터베이스 번호
	private String isbn;//책 식별번호
	private String title;//책 제목
	private String author;//책 저자
	private String publisher;//출판사
	private String publictionadate;//출판일
	private String price;//가격
	private String content;//내용
	private String bookimage;//메인 이미지
	private Float rating;//평점
	
	public Book() {
		
	}

	public Book(int id, String isbn, String title, String author, String publisher, String publictionadate, String price,
			String content, String bookimage, Float rating) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publictionadate = publictionadate;
		this.price = price;
		this.content = content;
		this.bookimage = bookimage;
		this.rating = rating;
	}
	
	public Book(String isbn, String title, String author,
	        String publisher, String publictionadate,
	        String price, String content, String bookimage, Float rating) {

	    this.isbn = isbn;
	    this.title = title;
	    this.author = author;
	    this.publisher = publisher;
	    this.publictionadate = publictionadate;
	    this.price = price;
	    this.content = content;
	    this.bookimage = bookimage;
	    this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	

	public String getPublictionadate() {
		return publictionadate;
	}

	public void setPublictionadate(String publictionadate) {
		this.publictionadate = publictionadate;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookimage() {
		return bookimage;
	}

	public void setBookimage(String bookimage) {
		this.bookimage = bookimage;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", publictionadate=" + publictionadate + ", price=" + price + ", content=" + content
				+ ", bookimage=" + bookimage + ", rating=" + rating + "]";
	}

	
	
	
	
	
}
