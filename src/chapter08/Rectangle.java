package chapter08;

public class Rectangle extends Shape implements ShapeInterface{
//	String color;
	int width;
	int height;
	
	public Rectangle(String color, int width, int height) {
		super(color);
//		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public void draw() {
		System.out.println(color + "사각형을 그린다.");
	}
}
