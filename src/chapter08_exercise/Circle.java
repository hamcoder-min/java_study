package chapter08_exercise;

public class Circle extends Shape implements ShapeInterface{
	int radius;
	public static final double PI = 3.14;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println(color + "원을 그리다");
	}
	
	public double getArea() {
		return PI * radius * radius;
	}

}
