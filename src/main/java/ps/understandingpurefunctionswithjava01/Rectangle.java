package ps.understandingpurefunctionswithjava01;

public class Rectangle {
	private double length;
	private double breadth;
	private double area;
	private double perimeter;
	
	public Rectangle(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}
	public Rectangle() {
		this.length=1;
		this.breadth=1;
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		if(length>0.0&& length<=20.0)
		this.length = length;
	}
	public double getBreadth() {
		return breadth;
	}
	public void setBreadth(double breadth) {
		if(breadth>0.0&& breadth<=20.0)
		this.breadth = breadth;
	}
	public void calcAreaofRectangle() {
		area=length*breadth;
	}
	public void calcPerimeter() {
		perimeter=2*(length+breadth);
		
	}
	public void displayArea() {
		String display= "Rectangle [length=" + length + ", breadth=" + breadth + ", area=" + area + ",perimeter="+ perimeter +"]";
		System.out.println(display);
	}
	
	

}
