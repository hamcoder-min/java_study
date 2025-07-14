package chapter08;

public class Triangle extends Shape implements ShapeInterface{
//	String color;
	
	public Triangle(String color) {
		super(color);
//		this.color = color;
	}
	
	@Override
	public double getArea() {
		return 0.0;
	}
	
	@Override
	public void draw() {
		System.out.println(color + "삼각형을 그린다.");
	}
}
