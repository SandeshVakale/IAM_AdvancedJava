package fr.epita.sandesh.Services;

import java.util.List;

/**
 * 
 * @author Sandesh VAKALE
 * @param <T>
 */
public interface Dao <T> {

public void write(T instance);
public void update(T instance);
public void delete(T instance);
public List<T>listall();
public List<T>searchBy(String addrs);
	
}
