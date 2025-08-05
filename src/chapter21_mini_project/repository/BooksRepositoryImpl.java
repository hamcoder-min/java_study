package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import db.DBConn;

public class BooksRepositoryImpl extends DBConn implements BookMarketRepositoryInterface<BookVo>{
	
	public int insert(BookVo book) {
		int rows = 0;
		return rows;
	}
	
	public String findId() {
		return null;
	}
	
	public List<BookVo> findAll(){
		List<BookVo> list = new ArrayList<BookVo>();
		return list;
	}
	
	public BookVo find(String id) {
		BookVo book = new BookVo();
		return book;
	}
	
	public int update(BookVo book) {
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
