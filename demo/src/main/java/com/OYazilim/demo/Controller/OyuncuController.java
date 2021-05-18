package com.OYazilim.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OYazilim.demo.Business.IFilmService;
import com.OYazilim.demo.Business.IOyuncuService;
import com.OYazilim.demo.Entities.Film;
import com.OYazilim.demo.Entities.Oyuncu;

@Controller
public class OyuncuController {

	private IOyuncuService oyuncuManager;
	private IFilmService filmManager;

	public OyuncuController(IOyuncuService oyuncuManager, IFilmService filmManager) {
		super();
		this.oyuncuManager = oyuncuManager;
		this.filmManager = filmManager;
	}
	
//	@GetMapping("/oyuncu")
//	public List<Oyuncu> getAll(){
//		List<Oyuncu> oyuncular=oyuncuManager.getAll();
//		System.out.println(oyuncular.get(0).getFilm().getAd());
//		return oyuncuManager.getAll();
//	}
//	
	Film film;
	@GetMapping("/addOyuncu/{id}")
	public String getAdd(Model model,@PathVariable("id") int id, Oyuncu oyuncu) {
		film=filmManager.getById(id);
		model.addAttribute("oyuncu",oyuncu);
		return "addOyuncu.html";
	}
	
	@PostMapping("/addOyuncu")
	public String add(Model model,Oyuncu oyuncu) {
		model.addAttribute("oyuncu",oyuncu);
		oyuncu.setFilm(film);
		oyuncuManager.insert(oyuncu);
		return "redirect:/menu";
	}
} 	
