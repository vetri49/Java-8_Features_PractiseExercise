package ps.understandingpurefunctionswithjava01;

import java.util.Scanner;

public class TestBooks {
   static int n;
   static Books[] book;
	public static void createBooks(Books[] book,int x) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<x;i++) {
			System.out.println("Enter a book title");
			String title=sc.next();
			System.out.println("Enter a book price");
			double price=sc.nextDouble();
			book[i]=new Books();
			book[i].setBookTitle(title);
			book[i].setBookPrice(price);
			
		}
		sc.close();
		
	}
	public static void showBooks() {
		for(Books boo:book) {
			System.out.println(boo);
			
		}
		
	}
	public static void main(String[] args) {
		n=2;
		book=new Books[n];
		createBooks(book,n);
		showBooks();
		

	}

}
