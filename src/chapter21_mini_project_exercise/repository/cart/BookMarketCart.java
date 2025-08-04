package chapter21_mini_project_exercise.repository.cart;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project_exercise.model.CartVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookMarketCart extends DBConn implements GenericRepositoryInterface<CartVo>{
	
	
	
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
		
		return list;
		
	}
	
	public CartVo find(String isbn) {
		CartVo cart = null;
		
		return cart;
	}
	
	public int update(CartVo cart) {
		int rows = 0;
		
		return rows;
	}
	
	public int remove(String isbn) {
		int rows = 0;
		
		return rows;
	}
	
	public void close() {
		
	}
	
	public int getCount() {
		int rows = 0;
		
		return rows;
	}
}
