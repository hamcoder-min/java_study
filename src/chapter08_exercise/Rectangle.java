package chapter08_exercise;

public class Rectangle extends Shape implements ShapeInterface{
	int weidth;
	int heigth;
	
	public Rectangle(String color, int weidth, int heigth) {
		super(color);
		this.weidth = weidth;
		this.heigth = heigth;
	}
	
	public void draw() {
		System.out.println(color + "사각형을 그린다.");
	}
	
	public double getArea() {
		return weidth * heigth;
	}

}
