package sample.spring.yes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeContorller {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("홈 컨트롤러");
		return new ModelAndView("/index"); 
	}
	
}
