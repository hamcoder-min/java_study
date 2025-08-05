package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.CartVo;
import db.DBConn;

public class CartRepositoryImpl extends DBConn implements BookMarketRepositoryInterface<CartVo>{
	
	public int insert(CartVo cart) {
		int rows = 0;
		return rows;
	}
	
	public String findId() {
		return null;
	}
	
	public List<CartVo> findAll(){
		List<CartVo> list = new ArrayList<CartVo>();
		return list;
	}
	
	public CartVo find(String id) {
		CartVo cart = new CartVo();
		return cart;
	}
	
	public int update(CartVo cart) {
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
	
	public void close() {}
}
