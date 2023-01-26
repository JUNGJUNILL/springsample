package sample.spring.yes;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	SqlSessionTemplate sqlSesstionTemplate; 	
	//SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다. 
	//SqlSessionTemplate 은 쓰레드에 안전하고 여러개의 DAO나 매퍼에서 공유할수 있다.
	
	public int insert(Map<String,Object> map) {
		return this.sqlSesstionTemplate.insert("book.insert",map);
	}	
	
	public Map<String,Object> selectDetail(Map<String,Object> map){
		return this.sqlSesstionTemplate.selectOne("book.select_detail",map);
	}
	
	public int update(Map<String,Object> map) {
		return this.sqlSesstionTemplate.update("book.update",map); 
	}
	
	public int delete(Map<String,Object> map) {
		return this.sqlSesstionTemplate.delete("book.delete",map); 
		
	}
	
	public List<Map<String,Object>> selectList(Map<String,Object> map){
		return this.sqlSesstionTemplate.selectList("book.select_list", map);
	}
	
	
	
}
