package sample.spring.yes;

import java.util.Map;

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
	}
	
	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		ModelAndView mv = new ModelAndView(); 
		
		String bookId= this.bookService.create(map); 
		if(bookId==null) {
			mv.setViewName("redirect:/create");
		}else{
			mv.setViewName("redirect:/detail?bookId="+bookId);
		}
		return mv; 
		
	}

}
