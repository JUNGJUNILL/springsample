package sample.spring.yes;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	SqlSessionTemplate sqlSesstionTemplate; 	
	
	public int insert(Map<String,Object> map) {
		return this.sqlSesstionTemplate.insert("book.insert",map); 
	}
	
	
	
	
}
