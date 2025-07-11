package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList();	//은행 시스템 확인
		
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();	// 싱글톤
		
		BankMan staffPark = new BankMan("박보검", kbsystem);	// 은행직원은 고객리스트 정보 가짐
		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0);
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
		staffPark.setAccountPaper(hong.getAccountPaper());	// 은행직원이 고객의 용지를 받는다.
		staffPark.validateCheck();	// 고객에게 전달받은 출금용지에 빈값이 있는지 체크!
		while(validateFlag) {
			if (staffPark.validateCheck(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		
		staffPark.processWithdrawal();
		
		kbsystem.confirmBalance(hong.getAccountPaper());	// ATM(은행시스템)을 이용하여 잔액을 확인
	}
}
