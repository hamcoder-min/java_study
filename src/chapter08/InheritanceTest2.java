package chapter08;

public class InheritanceTest2 {

	public static void main(String[] args) {

		Circle redC = new Circle("빨강색", 12);
		Circle blueC = new Circle("파랑색", 10);
		Rectangle yellowR = new Rectangle("노랑색", 10, 12);
		Rectangle greenR = new Rectangle("초록색", 8, 15);
		Triangle orangeT = new Triangle("주황색");
		
		redC.draw();
		System.out.println("redC.getArea : " + redC.getArea());
		
		blueC.draw();
		System.out.println("blueC.getArea : " + blueC.getArea());
		
		yellowR.draw();
		System.out.println("yellowR.getArea : " + yellowR.getArea());
		
		greenR.draw();
		System.out.println("greenR.getArea : " + greenR.getArea());
		
		orangeT.draw();
		System.out.println("orangeT.getArea : " + orangeT.getArea());

	}

}
