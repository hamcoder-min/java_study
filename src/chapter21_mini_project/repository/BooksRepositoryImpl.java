package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import db.DBConn;

public class BooksRepositoryImpl extends DBConn implements BookMarketRepositoryInterface<BookVo>{
	
	@Override
	public int insert(BookVo book) {
		int rows = 0;
		return rows;
	}
	
	@Override
	public String findId() {
		return null;
	}
	
	@Override
	public List<BookVo> findAll(){
		List<BookVo> list = new ArrayList<BookVo>();
		return list;
	}
	
	@Override
	public BookVo find(String id) {
		BookVo book = new BookVo();
		return book;
	}
	
	@Override
	public int update(BookVo book) {
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
