package chapter21_mini_project_exercise.repository.cart;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project_exercise.model.BookVo;
import chapter21_mini_project_exercise.model.CartVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookMarketCart extends DBConn implements GenericRepositoryInterface<CartVo>{
	private List<BookVo> list = new ArrayList<BookVo>();
	
	
	public int insert(CartVo cart) {
		int rows = 0;
		String sql = """
				insert into book_market_cart(title, author, price, quantity, total_due)
					values(?, ?, ?, ?, ?)
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cart.getTitle());
			pstmt.setString(2, cart.getAuthor());
			pstmt.setInt(3, cart.getPrice());
			pstmt.setInt(4, cart.getQuantity());
			pstmt.setInt(5, cart.getTotalDue());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public List<CartVo> findAll() {
		List<CartVo> list = new ArrayList<CartVo>();
		String sql = """
				select 	row_number() over() as rno
						, title
						, author
						, price
						, quantity
						, total_due
				from 	book_market_cart
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVo cart = new CartVo();
				cart.setRno(rs.getInt(1));
				cart.setIsbn(rs.getString(2));
				cart.setTitle(rs.getString(3));
				cart.setAuthor(rs.getString(4));
				cart.setPrice(rs.getInt(5));
				cart.setQuantity(rs.getInt(6));
				cart.setTotalDue(rs.getInt(7));
				
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public CartVo find(String isbn) {
		CartVo cart = null;
		String sql = """
				select 	isbn
						, title
						, author
						, price
						, quantity
						, total_due
				from	book_market_cart
				where	isbn = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart = new CartVo();
				cart.setIsbn(rs.getString(1));
				cart.setTitle(rs.getString(2));
				cart.setAuthor(rs.getString(3));
				cart.setPrice(rs.getInt(4));
				cart.setQuantity(rs.getInt(5));
				cart.setTotalDue(rs.getInt(6));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public int update(CartVo cart) {
		int rows = 0;
		String sql = """
				update book_market_cart
					set title = ?, author = ?, price = ?
				where isbn = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cart.getTitle());
			pstmt.setString(2, cart.getAuthor());
			pstmt.setInt(3, cart.getPrice());
			pstmt.setString(4, cart.getIsbn());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int remove(String isbn) {
		int rows = 0;
		String sql = """
				delete from book_market_cart
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
	
	public int removeAll() {
		int rows = 0;
		String sql = """
				delete from book_market_cart
				""";
		try {
			getPreparedStatement(sql);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int getCount() {
		int rows = 0;
		String sql = """
				select count(*) from book_market_cart
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
