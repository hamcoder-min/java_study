package chapter07;

public class AnimalAccessModifier {
	//Field
	String name;	//같은 패키지에서만 접근 가능
	int age;		//같은 패키지에서만 접근 가능
	
	private String pname;	//같은 클래스 내부에서만 접근 가능
	private int page;		//같은 클래스 내부에서만 접근 가능
	
	static String sname;	//static 변수, 클래스변수
	static int sage;		//static 변수, 클래스변수
	
	final String fname = "홍길동";	//final 키워드 적용 => 외부에서 값을 변경할 수 없음
	final int fage = 10;			//final 키워드 적용 => 외부에서 값을 변경할 수 없음
	
	//상수 정의
	public static final int START = 0;
	public static final int CONTINUE = 1;
	public static final int END = -1;
	
	
	//Constructor
	public AnimalAccessModifier() {}
	public AnimalAccessModifier(String pname, int page) {
		this.pname = pname;
		this.page = page;
	}
	
	//Method
	// static method
	void getInfo() { System.out.println(pname + ", " + page); };			// 같은 패키지 안에서만 호출이 가능한 메소드
	public void getInfo2() { System.out.println(pname + ", " + page); };	// 모든 클래스에서 접근 가능한 메소드
	public static void getInfo3() { System.out.println(sname + ", " + sage); };	// 모든 클래스에서 접근 가능한 메소드
	
	
	
	// getter
	public String getPname() { return pname; }
	public int getPage() { return page; }
	//setter
	public void setPname(String pname) { this.pname = pname;}
	public void setPage(int page) { this.page = page;}
	
}
