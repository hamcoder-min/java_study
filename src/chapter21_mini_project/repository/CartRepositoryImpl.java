package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.CartVo;
import db.DBConn;

public class CartRepositoryImpl extends DBConn implements BookMarketRepositoryInterface<CartVo>{
	
	@Override
	public int insert(CartVo cart) {
		int rows = 0;
		return rows;
	}
	
	@Override
	public String findId() {
		return null;
	}
	
	@Override
	public List<CartVo> findAll(){
		List<CartVo> list = new ArrayList<CartVo>();
		return list;
	}
	
	@Override
	public CartVo find(String id) {
		CartVo cart = new CartVo();
		return cart;
	}
	
	@Override
	public int update(CartVo cart) {
		int rows = 0;
		return rows;
	}
	
	@Override
	public int remove(String id) {
		int rows = 0;
		return rows;
	}
	
	@Override
	public int removeAll() {
		int rows = 0;
		return rows;
	}
	
	@Override
	public void close() {}
}
