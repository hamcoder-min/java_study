package com_exercise.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com_exercise.scoremgm.app.ScoreMgmSystem;
import com_exercise.scoremgm.model.Member;
import com_exercise.scoremgm.repository.ScoreRepository;
import com_exercise.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	@Override
	public void register() {
		List memberInfo = createMemberInfo();
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setMajor((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		if(repository.insert(member)) {
			System.out.println("=> 등록완료!!");
		} else {
			System.out.println("=> 등록실패!!");
		}
		sms.showMenu();
	}
	
	public List createMemberInfo() {
		String[] labels = { "학생명", "전공", "국어", "영어", "수학" };
		List memberInfo = new ArrayList();
		Random rd = new Random();
		String no = "2025-" + rd.nextInt(1000, 9999);
		memberInfo.add(no);
		
		for(int i = 0; i < labels.length; i++) {
			if(i >= 2) {
				System.out.print(labels[i] + " > ");
				memberInfo.add(sms.scan.next());
			} else {
				System.out.print(labels[i] + " > ");
				memberInfo.add(sms.scan.nextInt());
			}
		}
		return memberInfo;
	}
	
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			System.out.println("\n======================================================");
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			System.out.println("======================================================");
			list.forEach((member) -> {
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getMajor() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
			System.out.println("======================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
	}
	
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.println("학번(뒤 4자리) > ");
			String no = sms.scan.next();
			Member member = repository.find(no);
		}
	}
	
	@Override
	public void update() {}
	
	@Override
	public void delete() {}
	
	@Override
	public void exit() {}
	
	@Override
	public int getCount() {
		return 0;
	}
}
