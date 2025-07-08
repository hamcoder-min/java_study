package drink;

public class Payment {
	// Field
	int amount;
	int change;
	
	// Constructor
	public Payment() {}
	
	// Method
	public void setAmount(int amount)	{
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getPayment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			result = true;
		}		
		return result;
	}
}
