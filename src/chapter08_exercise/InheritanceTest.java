package chapter08_exercise;

public class InheritanceTest {

	public static void main(String[] args) {
		Circle redC = new Circle("빨간색", 12);
		Circle blueC = new Circle("파란색", 10);
		Rectangle yellowR = new Rectangle("노란색", 12, 8);
		Rectangle greenR = new Rectangle("초록색", 10, 9);
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
