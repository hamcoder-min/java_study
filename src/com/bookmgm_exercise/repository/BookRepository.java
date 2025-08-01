package com.bookmgm_exercise.repository;

import java.util.List;
import com.bookmgm_exercise.model.BookVo;


public interface BookRepository {
	boolean insert(BookVo book);
	List<BookVo> selectAll();
	BookVo select(String bid);
	void update(BookVo book);
	void remove(String bid);
	void remove(BookVo book);
	int getCount();
}
