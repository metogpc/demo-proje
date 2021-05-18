package com.OYazilim.demo.Controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.OYazilim.demo.Business.IFilmService;
import com.OYazilim.demo.Entities.Film;


@Controller
public class FilmController {

	private IFilmService filmManager;

	public FilmController(IFilmService filmManager) {
		super();
		this.filmManager = filmManager;
	}
	
	/*
	 * @GetMapping("/films") public List<Film> getAll(){ Film
	 * asd=filmManager.getById(1); List<Oyuncu> laguages=asd.getOyuncular();
	 * 
	 * return filmManager.getAll(); }
	 */

	@GetMapping("/menu")
	public String listFilm(Model model) {
		model.addAttribute("filmList",filmManager.getAll());
		return "menu";
	}

	@GetMapping("/menuSirali")
	public String listFilm2(Model model) {
		List<Film> filmList=filmManager.sortByYear();
		model.addAttribute("filmList",filmList);
		return "menu";
	}
	
	@GetMapping("menu/delete/{id}")
	public String deleteBook(Model model, @PathVariable("id") int id) {
		Film film=filmManager.getById(id);
		//System.out.println(film);
		filmManager.delete(film);
		return "redirect:/menu";
	}
	
	@GetMapping("/edit/{id}")
	public String getEditFilm(Model model, @PathVariable("id") int id) {
		Film film=filmManager.getById(id);
		model.addAttribute("film",film);
		//System.out.println(film.getId()+ film.getAd());
		return "editFilm";
	}
	
	@GetMapping("/film/{id}")
	public String getFilm(Model model , @PathVariable("id") int id) {
		Film film=filmManager.getById(id);
		//System.out.println(film.getOyuncular().get(0).getAd());
		model.addAttribute("film",film);
		model.addAttribute("oyuncular",film.getOyuncular());
		return "film";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model, Film film) {
		model.addAttribute("film",film);
		return "createFilm.html";
	}
	
	@PostMapping("/create")
	public String addFilm(Model model, Film film) {
		model.addAttribute("film",film);
		filmManager.insert(film);
		return "redirect:/menu";
	}
	
}
