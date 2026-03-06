package booklist;
//전체 출력 됬을때 의 북 리스트 내용
public class MainBook {
	private int id;//데이터 베이스 번호
	private String bookimage;//메인이미지
	private String title;//제목
	private String author;//저자
	private String publisher;//출판사
	private String publictiondate;//출판일
	private int price;//가격
	private String content;//내용
	private float rating;//평점
	
	public MainBook() {
		
	}

	public MainBook(int id, String bookimage, String title, String author, String publisher, String publictiondate,
			int price, String content, float rating) {
		this.id = id;
		this.bookimage = bookimage;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publictiondate = publictiondate;
		this.price = price;
		this.content = content;
		this.rating = rating;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookimage() {
		return bookimage;
	}

	public void setBookimage(String bookimage) {
		this.bookimage = bookimage;
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


	public String getPublictiondate() {
		return publictiondate;
	}

	public void setPublictiondate(String publictiondate) {
		this.publictiondate = publictiondate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MainBook [id=" + id + ", bookimage=" + bookimage + ", title=" + title + ", author=" + author
				+ ", publisher=" + publisher + ", publictiondate=" + publictiondate + ", price=" + price + ", content="
				+ content + ", rating=" + rating + "]";
	}


	
	
	
	
}
