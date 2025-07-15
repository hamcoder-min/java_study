package drink_interface;

//import commons.Menu;

public class Order {
	// Field
	Menu orderMenu;
	
	// Constructor
	public Order() {}
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	// Method
	public void getInfo() {
		String price = String.format("%,d", orderMenu.getPrice());
		System.out.println("=> 주문메뉴 : " + orderMenu.getName() + ", 결제 예정 금액 : " + price + "원");
		
	}
	
	public String getName() {
		return orderMenu.getName();
	}
	
	public int getTotal() {
		return orderMenu.getPrice();
	}
}
