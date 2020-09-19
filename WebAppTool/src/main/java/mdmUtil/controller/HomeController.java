package mdmUtil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/test")
	public ModelAndView test() {
		System.out.println("In the test URL,test");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test");
		System.out.println(modelAndView.getViewName());
		modelAndView.addObject("id", 1324);
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(321);
		list.add(8462);
		modelAndView.addObject("numbers", list);

		return modelAndView;
	}

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("In the home URL");
		model.addAttribute("name", "Husain Akil Raja");

		return "home";
	}
}
