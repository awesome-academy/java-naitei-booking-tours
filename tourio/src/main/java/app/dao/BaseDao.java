package app.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class, readOnly = true)
public interface BaseDao<T> {

    // CRUD operations

    @Transactional(readOnly = false)
	boolean add(T t);

    @Transactional(readOnly = false)
    boolean update(T t);

    T get(Integer id);

    @Transactional(readOnly = false)
    void delete(Integer id);

    // Queries
    List<T> getAll();
}