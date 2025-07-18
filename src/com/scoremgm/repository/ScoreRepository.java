package com.scoremgm.repository;

import java.util.List;

import com.scoremgm.model.Member;

public interface ScoreRepository {
	void remove(String no);
	void update(Member member);
	Member find(String no);
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();
}
