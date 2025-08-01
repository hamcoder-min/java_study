package com.bookmgm_exercise.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmgm_exercise.model.BookVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class InMemoryBookRepository extends DBConn implements GenericRepositoryInterface<BookVo>{
	
	static final String TJ = "book_tj";
	static final String YES24 = "book_yes24";
	static final String ALADIN = "book_aladin";
	String tableName = "";
	
	public InMemoryBookRepository(int rno) {
		createTitle(rno);
	}
	
	public void createTitle(int rno) {
		String name = null;
		if(rno ==1) {
			name = "교육센터";
			tableName = TJ;
		}
		else if(rno == 2) {
			name = "알라딘";
			tableName = ALADIN;
		}
		else if(rno == 3) {
			name = "예스24";
			tableName = YES24;
		}
		System.out.println("** " + name + " 도서관 생성 완료 **");
	}

	public int insert(BookVo book) {
		int rows = 0;
		String sql = "insert into " + tableName + "(title, author, price, isbn, bdate) "
				+ " values(?, ?, ?, ?, now())";
						
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
		
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int getCount() {
		int rows = 0;
		String sql = "select count(*) as count from " + tableName;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public List<BookVo> findAll() {
		List<BookVo> list = null;
		String sql = "select row_number() over(order by bid) as rno, bid, title, author, price, isbn, bdate from " + tableName;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<BookVo>();
				while(rs.next()) {
					BookVo book = new BookVo();
					book.setRno(rs.getInt(1));
					book.setBid(rs.getString(2));
					book.setTitle(rs.getString(3));
					book.setAuthor(rs.getString(4));
					book.setPrice(rs.getInt(5));
					book.setIsbn(rs.getInt(6));
					book.setBdate(rs.getString(7));
					
					list.add(book);
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public BookVo find(String bid) {
		BookVo book = null;
		String sql = "select bid, title, author, price, isbn, bdate from " + tableName + " where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookVo();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	public int update(BookVo book) {
		int rows = 0;
		String sql = "update " + tableName + " set title = ?, author = ?, price = ? where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int remove(String bid) {
		int rows = 0;
		String sql = "delete from " + tableName + " where bid = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
}
