package chapter08_exercise;

public class Triangle extends Shape implements ShapeInterface{
	
	public Triangle(String color) {
		super(color);
	}
	
	public void draw() {
		System.out.println(color + "삼각형을 그린다.");
	}
	
	public double getArea() { return 0; }

}
