package com.bookmgm_exercise.service;

import java.util.List;
import java.util.Random;

import com.bookmgm_exercise.application.BookManagementApplication;
import com.bookmgm_exercise.model.BookVo;
import com.bookmgm_exercise.repository.AladinBookRepository;
import com.bookmgm_exercise.repository.InMemoryBookRepository;
import com.bookmgm_exercise.repository.Yes24BookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService{
	BookManagementApplication bma;
	GenericRepositoryInterface<BookVo> repository;
	
	public DefaultBookService() {}
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		selectRepository();
//		repository = new InMemoryBookRepository();
	}
	
	/**
	 * 도서 생성
	 */
	public BookVo createBook() {
		Random rd = new Random();
		BookVo book = new BookVo();
		
		book.setIsbn(rd.nextInt(1000, 9999));
		
		System.out.print("도서명 > ");
		book.setTitle(bma.scan.next());
		
		System.out.print("저자 > ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격 > ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서 생성
	 * @param book - old book
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public BookVo createBook(BookVo book) {		
		System.out.print("도서명 > ");
		book.setTitle(bma.scan.next());
		
		System.out.print("저자 > ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격 > ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서관 선택
	 */
	public void selectRepository() {
		System.out.println("\n=========================================");
		System.out.println("1. 교육센터\t2. 알라딘\t\t3. 예스24");
		System.out.println("=========================================");
		System.out.print("도서관 선택 > ");
		int rno = bma.scan.nextInt();
		if(rno == 1) {
			repository = new InMemoryBookRepository(1);
		} else if(rno == 2) {
			repository = new InMemoryBookRepository(2);
		} else if(rno == 3) {
			repository = new InMemoryBookRepository(3);
		}
	}
	
	/**
	 * 도서 등록
	 */
	@Override
	public void register() {
//		selectRepository();
		BookVo book = createBook();
		if(repository.insert(book) == 1) {
			System.out.println("✅ 도서가 등록되었습니다.");
		} else {
			System.out.println("❎ 도서가 등록되지 않았습니다.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서 조회
	 */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<BookVo> library = repository.findAll();
			library.forEach((book) -> {
				System.out.println("\n=======================================");
				System.out.println("도서번호\t제목\t작가\t가격\tisbn");
				System.out.println("=======================================");
				System.out.print("[" + book.getBid() + "]\t");
				System.out.print(book.getTitle() + "\t");
				System.out.print(book.getAuthor() + "\t");
				System.out.print(book.getPrice() + "\t");
				System.out.print(book.getIsbn() + "\n");
				System.out.println("=======================================");
			});
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서검색
	 */
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.print("도서번호 > ");
			BookVo book = repository.find(bma.scan.next());
			if(book != null) {
				printBook(book);
			} else {
				System.out.println("❌ 검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * @param book
	 */
	public void printBook(BookVo book) {
		System.out.println("\n========================================");
		System.out.println("도서번호\t제목\t작가\t가격\tisbn");
		System.out.println("=======================================");
		System.out.print("[" + book.getBid() + "]\t");
		System.out.print(book.getTitle() + "\t");
		System.out.print(book.getAuthor() + "\t");
		System.out.print(book.getPrice() + "\t");
		System.out.print(book.getIsbn() + "\n");
		System.out.println("=======================================");
	}
	
	/**
	 * 도서 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("도서번호 > ");
			BookVo book = repository.find(bma.scan.next());
			if(book != null) {
				repository.update(createBook(book));
				System.out.println("✅ 도서가 수정되었습니다.");
				printBook(book);
			} else {
				System.out.println("❌ 검색한 도서가 존재하지 않습니다.");
			}
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서 삭제 
	 */
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.print("도서번호 > ");
			BookVo book = repository.find(bma.scan.next());
			if(book != null) {
					repository.remove(book.getBid());
					System.out.println("✅ 도서가 삭제되었습니다.");
			}
		} else {
			System.out.println("❌ 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}	
	
	@Override
	public void exit() {
		System.out.println("✅ 프로그램이 종료됩니다.");
		repository.close();
		System.exit(0);
	}
	
	@Override
	public int getCount() {
		return repository.getCount();
	}
}
