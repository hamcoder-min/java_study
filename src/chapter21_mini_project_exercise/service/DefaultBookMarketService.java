package chapter21_mini_project_exercise.service;


import java.util.List;

import chapter21_mini_project_exercise.application.BookMarketApplication;
import chapter21_mini_project_exercise.model.BookVo;
import chapter21_mini_project_exercise.model.CartVo;
import chapter21_mini_project_exercise.model.MemberVo;
import db.GenericRepositoryInterface;

public class DefaultBookMarketService implements BookMarketService{
	BookMarketApplication bma;
	GenericRepositoryInterface<BookVo> bookRepository;
	GenericRepositoryInterface<CartVo> cartRepository;
	GenericRepositoryInterface<MemberVo> memberRepository;
	MemberVo member = new MemberVo();
	BookVo book = new BookVo();
	CartVo cart = new CartVo();
	
	public DefaultBookMarketService() {}
	public DefaultBookMarketService(BookMarketApplication bma) {
		this.bma = bma;
//		customerInfo();
	}
	
	
	/**
	 * 회원 정보
	 */
	public MemberVo customerInfo() {
		System.out.print("당신의 이름을 입력하세요 : ");
		member.setCustomerName(bma.scan.next());
		System.out.print("연락처를 입력하세요 : ");
		member.setPhone(bma.scan.next());
		bma.showMenu();
		return member;
	}
	
	public void menuGuestInfo() {
		System.out.println("현재 고객 정보 : ");
		System.out.println("이름  " + member.getCustomerName() + "\t연락처  " + member.getPhone());
	}
	
	public void menuCartItemList() {
		if(getCount() != 0) {
			List<CartVo> cart = cartRepository.findAll();
			cart.forEach((item) -> {
				System.out.print("[" + item.getIsbn() + "]\t");
				System.out.print(item.getTitle() + " | ");
				System.out.print(item.getPrice() + " | ");
				System.out.print(item.getAuthor() + " | ");
				System.out.print(item.getQuantity() + " | ");
				System.out.print(item.getTotalDue() + "\n");
			});
			
		}
	}
	
	public void menuCartClear() {}
	
	public void menuCartAddItem() {
		if(getCount() != 0) {
			List<BookVo> list = bookRepository.findAll();
			list.forEach((book) -> {
				System.out.print("[" + book.getIsbn() + "]\t");
				System.out.print(book.getTitle() + " | ");
				System.out.print(book.getPrice() + " | ");
				System.out.print(book.getAuthor() + " | ");
				System.out.print(book.getInfo() + " | ");
				System.out.print(book.getCategory() + " | ");
				System.out.print(book.getBdate() + "\n");
			});
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		if(getCount() != 0) {
			System.out.print("장바구니에 추가 할 도서의 ID를 입력해 주세요");
			BookVo book = bookRepository.find(bma.scan.next());
			if(book == null) {
			System.out.println("❌ 검색한 도서가 존재하지 않습니다.");
		}
			System.out.print("장바구니에 추가하시겠습니까? (Y | N)");
			if(bma.scan.next().equals("Y")) {
				System.out.println(bookRepository.find(bma.scan.next()) + " 도서가 장바구니에 추가되었습니다.");
			} else if(bma.scan.next().equals("N")) {
				System.out.println("장바구니 등록이 취소되었습니다.");
			}
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		
	}
	
	public void menuCartRemoveItemCount() {}
	
	public void menuCartRemoveItem() {}
	
	public void menuCartBill() {}
	
	public void menuExit() {
		System.out.println("✅ 프로그램이 종료됩니다.");
		if(cartRepository != null) {
			cartRepository.close();
		}
		System.exit(0);
	}
	
	public int getCount() {
		return cartRepository.getCount();
	}

}
