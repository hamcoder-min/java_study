package com_exercise.scoremgm.app;

import java.util.Scanner;

import com_exercise.scoremgm.service.ScoreService;
import com_exercise.scoremgm.service.ScoreServiceImpl;

public class ScoreMgmSystem {
	public Scanner scan;
	ScoreService service;
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	public ScoreMgmSystem() {
		scan = new Scanner(System.in);
		service = new ScoreServiceImpl();
		showMenu();
	}
	
	public void showMenu() {
		System.out.println("\n===========================================");
		System.out.println("\t더조은 고등학교 성적관리 프로그램");
		System.out.println("\t\t전체 학생수 : " + service.getCount());
		System.out.println("===========================================");
		System.out.println("\t\t1. 등록");
		System.out.println("\t\t2. 조회");
		System.out.println("\t\t3. 검색");
		System.out.println("\t\t4. 수정");
		System.out.println("\t\t5. 삭제");
		System.out.println("\t\t6. 종료");
		System.out.println("===========================================");
		selectMenu();
	}
	
	public void selectMenu() {
		System.out.print("메뉴 선택(숫자) > ");
		if(scan.hasNextInt()) {
			switch(scan.nextInt()) {
			case REGISTER : service.register();	break;
			case LIST : service.list();			break;
			case SEARCH : service.search();		break;
			case UPDATE : service.update();		break;
			case DELETE : service.delete();		break;
			case EXIT : service.exit();			break;
			default : 
				System.out.println("=> 메뉴 준비중입니다.");
				showMenu();
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
}
