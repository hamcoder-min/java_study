package chapter21_mini_project_exercise.model;

public class CartVo {
	private int rno;
	private String isbn;
	private String title;
	private String author;
	private int price;
	private int quantity;
	private int totalDue;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(int totalDue) {
		this.totalDue = totalDue;
	}
}
