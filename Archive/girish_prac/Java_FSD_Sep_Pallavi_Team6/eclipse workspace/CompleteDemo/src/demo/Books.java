package demo;

public class Books {
	private int bookId;
	private String title;
	private double price;
	
	public Books(int id, String name, double rate) {
		this.bookId = id;
		this.title = name; 
		this.price = rate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book Id: " + bookId + ", Title: " + title + ", Price: " + price;
	}
}
