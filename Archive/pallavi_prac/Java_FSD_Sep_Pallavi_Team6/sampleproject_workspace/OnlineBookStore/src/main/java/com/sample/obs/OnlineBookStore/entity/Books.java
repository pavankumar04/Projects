package com.sample.obs.OnlineBookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Books class.
 * @author Pallavi Prasad
 *
 */
@Entity
@Table(name = "books")
public class Books {
	@Id
	@Column(name = "bookid")
	private long bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "storeid")
	private long storeId;
	
	@Column(name = "no_copies")
	private int no_copies;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "availability")
	private boolean availability;
	
	/**
	 * default constructor.
	 */
	public Books() {
		
	}

	/**
	 * parameterized constructor.
	 * @param bookId long
	 * @param title String
	 * @param author String
	 * @param storeId long
	 * @param no_copies int
	 * @param category String
	 * @param price double
	 * @param availability boolean
	 */
	public Books(long bookId, String title, String author, long storeId, int no_copies, String category, double price,
			boolean availability) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.storeId = storeId;
		this.no_copies = no_copies;
		this.category = category;
		this.price = price;
		this.availability = availability;
	}

	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the storeId
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the no_copies
	 */
	public int getNo_copies() {
		return no_copies;
	}

	/**
	 * @param no_copies the no_copies to set
	 */
	public void setNo_copies(int no_copies) {
		this.no_copies = no_copies;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the availability
	 */
	public boolean isAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	/**
	 * toString method.
	 * @return String
	 */
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", author=" + author + ", storeId=" + storeId
				+ ", no_copies=" + no_copies + ", category=" + category + ", price=" + price + ", availability="
				+ availability + "]";
	}
}
