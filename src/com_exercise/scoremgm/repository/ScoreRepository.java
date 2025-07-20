package com_exercise.scoremgm.repository;

import java.util.List;

import com_exercise.scoremgm.model.Member;

public interface ScoreRepository {
	boolean insert(Member member);
	List<Member> findAll();
	int getCount();
	Member find(String no);
}
