package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	int insert(T entity);
	List<T> findAll();
	int getCount();
	T find(String id);
	int update(T entity);
	int remove(String id);
	void close();
}
