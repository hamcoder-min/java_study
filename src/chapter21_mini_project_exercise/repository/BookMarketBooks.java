package chapter21_mini_project_exercise.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project_exercise.model.BookVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookMarketBooks extends DBConn implements GenericRepositoryInterface<BookVo>{
	
	public int insert(BookVo book) {
		int rows = 0;
		String sql = """
				insert into book_market_books(title, author, price, info, category, bdate)
					values(?, ?, ?, ?, ?, now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getInfo());
			pstmt.setString(5, book.getCategory());
		
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public List<BookVo> findAll() {
		List<BookVo> list = new ArrayList<BookVo>();
		String sql = """
				select 	row_number() over() as rno
						, isbn
						, title
						, author
						, price
						, info
						, category
						, bdate
				from 	book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo book = new BookVo();
				book.setRno(rs.getInt(1));
				book.setIsbn(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setInfo(rs.getString(6));
				book.setCategory(rs.getString(7));
				book.setBdate(rs.getString(8));
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public BookVo find(String isbn) {
		BookVo book = null;
		String sql = """
				select	isbn
						, title
						, author
						, price
						, info
						, category
						, bdate
				from 	book_market_books
				where	isbn = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookVo();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setInfo(rs.getString(5));
				book.setCategory(rs.getString(6));
				book.setBdate(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public int update(BookVo book) {
		int rows = 0;
		String sql = """
				update book_market_books
					set title = ?, author = ?, price = ?, info = ?, category = ?
					where isbn = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getInfo());
			pstmt.setString(5, book.getCategory());
			pstmt.setString(6, book.getIsbn());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int remove(String isbn) {
		int rows = 0;
		String sql = """
				delete from book_market_books
				where isbn = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, isbn);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int getCount() {
		int rows = 0;
		String sql = """
				select count(*) from book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
