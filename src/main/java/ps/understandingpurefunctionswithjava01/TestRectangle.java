package ps.understandingpurefunctionswithjava01;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r1=new Rectangle(12,15);
		Rectangle r2=new Rectangle(19,14);
		Rectangle r3=new Rectangle(11,10);
		Rectangle r4=new Rectangle(18,26);
		Rectangle r5=new Rectangle(9,5);
		Rectangle[] arr=new Rectangle[] {r1,r2,r3,r4,r5};
		
		
		for(Rectangle recs:arr) {
			recs.calcAreaofRectangle();
			recs.calcPerimeter();
			recs.displayArea();
			
			
		}
		
	

	}

}
