package chapter17;

public class ThreadExtend extends Thread{

	public ThreadExtend() {
		super("쓰레드1");
	}
	
	@Override
	public void run() {
		//1~10 정수 출력
		for(int i = 1; i <= 10; i++) {
			try {
				sleep(1000);	//1초 sleep
				System.out.println(getName() + " ----------> " + i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
