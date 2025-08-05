package chapter21_mini_project.service;

import java.util.List;

import chapter21_mini_project.application.BookMarketSystem;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import chapter21_mini_project.model.MemberVo;
import chapter21_mini_project.repository.BookMarketRepositoryInterface;
import chapter21_mini_project.repository.BooksRepositoryImpl;
import chapter21_mini_project.repository.CartRepositoryImpl;
import chapter21_mini_project.repository.MemberRepositoryImpl;

public class BookMarketServiceImpl implements BookMarketService{
	BookMarketSystem bms;
	BookMarketRepositoryInterface<BookVo> booksRepository;
	BookMarketRepositoryInterface<CartVo> cartRepository;
	BookMarketRepositoryInterface<MemberVo> memberRepository;
	String mid;
	
	
	public BookMarketServiceImpl(BookMarketSystem bms) {
		this.bms = bms;
		booksRepository = new BooksRepositoryImpl();
		cartRepository = new CartRepositoryImpl();
		memberRepository = new MemberRepositoryImpl();
	}
	
	@Override
	public void menuMemberAdd() {
		MemberVo member = new MemberVo();
		System.out.print("회원명 > ");
		member.setName(bms.scan.next());
		System.out.print("주소 > ");
		bms.scan.nextLine();	//nextLine() : 띄어쓰기 필요한 문장 입력시, \n을 포함
		member.setAddress(bms.scan.nextLine());	
		System.out.print("전화번호 > ");
		member.setPhone(bms.scan.nextLine());
		
		memberRepository.insert(member);
		this.mid = memberRepository.findId();	//방금 회원 등록한 회원의 mid 가져오기
		
	}
	
	@Override
	public void menuMemberInfo() {
		MemberVo member = memberRepository.find(mid);
		if(member != null) {
			System.out.println("\n-----------------------------------------------------");
			System.out.print(member.getMid() + "\t");
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAddress() + "\t");
			System.out.print(member.getPhone() + "\t");
			System.out.print(member.getMdate() + "\n");
			System.out.println("-----------------------------------------------------");
		} else {
			System.out.println("🚫 등록된 회원이 존재하지 않습니다!");
		}
		bms.selectMenu();
	}
	
	@Override
	public void menuCartList() {
		List<CartVo> list = cartRepository.findAll();
		for(CartVo cart : list) {
			System.out.print("[" + cart.getCid() + "]\t");
			System.out.print(cart.getBid() + "\t");
			System.out.print(cart.getQty() + "\n");
		}
	}
	
	@Override
	public void menuCartClear() {
		CartVo cart = cartRepository.find(mid);
		if(cart != null) {
			System.out.println("장바구니의 모든 항목을 삭제합니다! (Y | N)");
			if(bms.scan.next().equals("Y")) {
				System.out.println("삭제 완료!");
				cartRepository.removeAll();
			}
		}
	}
	
	@Override
	public void menuCartAddItem() {}
	
	@Override
	public void menuCartRemoveItem() {}
	
	@Override
	public void menuCartBill() {}
	
	@Override
	public void exit() {
		System.out.println("-- 북마켓을 종료합니다! --");
		booksRepository.close();
		cartRepository.close();
		memberRepository.close();
		System.exit(0);
	}

}
