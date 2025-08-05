package chapter21_mini_project_exercise.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project_exercise.model.MemberVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookMarketMember extends DBConn implements GenericRepositoryInterface<MemberVo>{
	
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into book_market_member(
					customer_id
					, customer_name
					, phone
					, email
					, address
					, register_date)
					values(?, ?, ?, ?, ?, now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getCustomerId());
			pstmt.setString(2, member.getCustomerName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public List<MemberVo> findAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select 	row_number() over() as rno
						, customer_id
						, customer_name
						, phone
						, email
						, address
						, register_date
				from 	book_market_member
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setRno(rs.getInt(1));
				member.setCustomerId(rs.getString(2));
				member.setCustomerName(rs.getString(3));
				member.setPhone(rs.getString(4));
				member.setEmail(rs.getString(5));
				member.setAddress(rs.getString(6));
				member.setRegisterDate(rs.getString(7));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public MemberVo find(String id) {
		MemberVo member = null;
		
				
		return member;
		
	}
	
	public int update(MemberVo member) {
		int rows = 0;
		
		return rows;
	}
	
	public int remove(String id) {
		int rows = 0;
		String sql = """
				delete from book_market_member
				where customer_id = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int getCount() {
		int rows = 0;
		String sql = """
				select count(*) from book_market_member
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
