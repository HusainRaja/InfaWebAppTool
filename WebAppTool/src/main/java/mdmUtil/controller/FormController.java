package mdmUtil.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mdmUtil.model.MDMConnection;
import mdmUtil.model.User;
import mdmUtil.service.MDMService;

@Controller
public class FormController {

	@Autowired
	MDMService mdmService;

	@Autowired
	MDMConnection mdmConnection;

	@RequestMapping("/myLogin")
	public String contactForm() {

		System.out.println("In the login URL");
		return "login";
	}

	@RequestMapping(path = "/appLogin", method = RequestMethod.POST)
	public String contactProcess(@ModelAttribute User user,Model model) {

		System.out.println(user);

		System.out.println(mdmConnection);

		System.out.println("Calling the authenticate call");
		System.out.println();

		if (mdmService.authenticateUser()) {
			return "index";

		} else {
			model.addAttribute("status", "Invalid Username/password");
			return "login";
		}
		
		

	}
	
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }  

}
