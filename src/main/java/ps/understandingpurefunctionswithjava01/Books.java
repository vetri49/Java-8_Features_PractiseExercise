package ps.understandingpurefunctionswithjava01;

public class Books {
	private String bookTitle;
	private double bookPrice;
	
	public Books(String bookTitle, double bookPrice) {
		super();
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}
	public Books() {
		this.bookPrice=0;
		this.bookTitle="";
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Books [bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
	
	

}
