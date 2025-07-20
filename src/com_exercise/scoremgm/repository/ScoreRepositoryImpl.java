package com_exercise.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com_exercise.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	List<Member> storage = new ArrayList<Member>();
	
	@Override
	public boolean insert(Member member) {
		if(member == null) {
			return false;
		}
		return storage.add(member);
	}
	
	@Override
	public List<Member> findAll() {
		return storage;
	}
	
	@Override
	public int getCount() {
		return 0;
	}
	
	@Override
	public Member find(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
		}
		return member;
	}
	
}
