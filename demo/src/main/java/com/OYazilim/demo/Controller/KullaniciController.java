package com.OYazilim.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.OYazilim.demo.Business.IUserService;
import com.OYazilim.demo.Entities.User;

@Controller
public class KullaniciController {

	private IUserService userManager;
	
	@Autowired
	public KullaniciController(IUserService userManager) {
		super();
		this.userManager = userManager;
	}


	@GetMapping("/")
	public String getLogin() {
		return "login.html";
	}
	

	@PostMapping("/login")
	public String login(Model model,User user) {
		model.addAttribute("user",user);
		List<User> users= userManager.getAll();
		boolean a=false;
		
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getNickname().equals(user.getNickname()) && users.get(i).getPassword().equals(user.getPassword())) {
				a=true;
				break;
			}
		}
		
		if (a) {
			System.out.println("Giriş başarılı");
			return "redirect:/menu";
		}
		else {
			System.out.println("Giriş başarısız");
			return "redirect:/";
		}

	}
	

	@GetMapping("/register")
	public String getRegister() {
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(Model model,User user) {
		try {
			model.addAttribute("user",user);
			System.out.println(" register");
			System.out.println(user.toString());
			userManager.insert(user);
			return "redirect:/";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lütfen farklı bir nickname giriniz");
			return "redirect:/register";
		}
	}
}
