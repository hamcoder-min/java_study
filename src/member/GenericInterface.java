package member;

import java.util.List;

public interface GenericInterface<T> {
	public int insert(T entity);
	public List<T>listAll();
	public T search(int id);
	public List<T> search(String name);
	public int update(T entity);
	public int delete(int id);
}
