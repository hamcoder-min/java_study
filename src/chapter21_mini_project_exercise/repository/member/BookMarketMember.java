package chapter21_mini_project_exercise.repository.member;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project_exercise.model.MemberVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookMarketMember extends DBConn implements GenericRepositoryInterface<MemberVo>{
	
	public int insert(MemberVo member) {
		int rows = 0;
		
		return rows;
	}
	
	public List<MemberVo> findAll() {
		List<MemberVo> member = new ArrayList<MemberVo>();
		
		return member;
	}
	
	public int getCount() {
		int rows = 0;
		
		return rows;
	}
	
	public MemberVo find(String isbn) {
		MemberVo member = null;
				
		return member;
		
	}
	
	public int update(MemberVo member) {
		int rows = 0;
		
		return rows;
	}
	
	public int remove(String id) {
		int rows = 0;
		
		return rows;
	}
	
	public void close() {
		
	}
	
}
