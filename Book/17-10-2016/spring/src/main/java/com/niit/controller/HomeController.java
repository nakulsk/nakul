package com.niit.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String HomePage() {
		return "home";

	}
	@RequestMapping("/homePage")
	public String homePage() {
		return "homePage";
	}

	@RequestMapping("/about")
	public String aboutUs() {
		return "about";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null)
			model.addAttribute("error", "invalid username and password");
		return "login";
	}

}
