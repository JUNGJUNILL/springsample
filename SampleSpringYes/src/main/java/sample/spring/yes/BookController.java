package sample.spring.yes;

import java.util.*;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/create" , method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create"); 
		//æ»≥Á«œººø‰!
	}
	
	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		ModelAndView mv = new ModelAndView(); 
		
        for (Entry<String, Object> entrySet : map.entrySet()) {
            System.out.println("createPost="+entrySet.getKey() + " : " + entrySet.getValue());
        }
		
		String bookId= this.bookService.create(map); 
		System.out.println("bookId="+bookId);
		if(bookId==null) {
			mv.setViewName("redirect:/create");
		}else{
			mv.setViewName("redirect:/detail?bookId="+bookId);
		}
		return mv; 
		
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.bookService.detail(map);
	    
        for (Entry<String, Object> entrySet : map.entrySet()) {
            System.out.println("detail="+entrySet.getKey() + " : " + entrySet.getValue());
        }
	    
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("data", detailMap);
	    String bookId = map.get("bookId").toString(); 
	    mv.addObject("bookId", bookId);
	    mv.setViewName("/book/detail");
	    
	    return mv; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)  
	public ModelAndView update(@RequestParam Map<String, Object> map) {  
		Map<String, Object> detailMap = this.bookService.detail(map);  
		
        for (Entry<String, Object> entrySet : map.entrySet()) {
            System.out.println("update="+entrySet.getKey() + " : " + entrySet.getValue());
        }
	
		ModelAndView mv = new ModelAndView();  
		mv.addObject("data", detailMap);  
		mv.setViewName("/book/update");  
		
		return mv;  
	}  
	
	@RequestMapping(value = "update", method = RequestMethod.POST)  
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {  
		ModelAndView mv = new ModelAndView();  
		
		boolean isUpdateSuccess = this.bookService.edit(map); 
		if(isUpdateSuccess) {
			String bookId = map.get("bookId").toString(); 
			mv.setViewName("redirect:/detail?bookId="+bookId);
		}else {
			mv = this.update(map); 
		}
		
		return mv;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)  
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {  
		ModelAndView mv = new ModelAndView();  
		
		boolean isDeleteSuccess = this.bookService.remove(map); 
		if(isDeleteSuccess) {
			mv.setViewName("redirect:/list");
		}else {
			String bookId=map.get("bookId").toString(); 
			mv.setViewName("redirect:/detail?bookId="+bookId);
		}
		
		return mv; 
	}  
	
	@RequestMapping(value = "list")  
	public ModelAndView list(@RequestParam Map<String, Object> map) {  
		ModelAndView mv = new ModelAndView();  

		List<Map<String,Object>> list = this.bookService.list(map); 
		mv.addObject("data",list); 
		mv.setViewName("/book/list");
		
		
		return mv; 

	}
	

}
