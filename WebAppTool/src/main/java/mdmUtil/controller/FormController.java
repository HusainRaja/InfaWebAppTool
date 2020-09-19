package mdmUtil.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/")
	public String contactForm() {

		System.out.println("In the login URL");
		return "login";
	}

	@RequestMapping(path = "/loginProcess", method = RequestMethod.POST)
	public String contactProcess(@ModelAttribute User user,Model model) {

		System.out.println(user);

		System.out.println(mdmConnection);

		System.out.println("Calling the authenticate call");
		System.out.println();

		if (mdmService.authenticateUser(user)) {
			return "success";

		} else {
			model.addAttribute("status", "Invalid Username/password");
			return "login";
		}

	}

}
