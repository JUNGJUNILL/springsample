package sample.spring.yes;

import java.util.*;

public interface BookService {

	public String create(Map<String,Object> map);
	public Map<String,Object> detail(Map<String,Object> map); 
	public boolean edit(Map<String,Object> map); 
	public boolean remove(Map<String,Object> map); 
	public List<Map<String,Object>> list(Map<String,Object> map); 

}
