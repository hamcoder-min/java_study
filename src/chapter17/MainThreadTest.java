package chapter17;

public class MainThreadTest {

	public static void main(String[] args) {	//mainThread
		// 1~10 정수 출력
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		ThreadExtend te = new ThreadExtend();	//te Thread : 독립된 실행 - 각자 실행 후 종료
		te.start();
		
		Thread t = new Thread(new RunnableImpl());	//t Thread : 독립된 실행 - 각자 실행 후 종료
		t.start();
		
		
		System.out.println("-- main 메소드 종료 --");
		

	}

}