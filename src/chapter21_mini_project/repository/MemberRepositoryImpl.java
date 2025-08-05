package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.MemberVo;
import db.DBConn;


public class MemberRepositoryImpl extends DBConn implements BookMarketRepositoryInterface<MemberVo>{
	
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into book_market_member(name, address,  phone, mdate)
					values(?, ?, ?, now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getAddress());
			pstmt.setString(3, member.getPhone());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public String findId() {
		return null;
	}
	
	public List<MemberVo> findAll(){
		List<MemberVo> list = null;
		String sql = """
				select	mid
						, name
						, address
						, phone
						, mdate
				from 	book_market_member
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setAddress(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMdate(rs.getString(5));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberVo find(String mid) {
		MemberVo member = null;
		String sql = """
				select	mid
						, name
						, address
						, phone
						, madate
				from 	book_market_member
				where	mid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVo();
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setAddress(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setMdate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public int removeAll() {
		int rows = 0;
		return rows;
	}
	
}
