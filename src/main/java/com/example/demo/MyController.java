package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	ArrayList<Prodotto> listaP = new ArrayList<>();

	@GetMapping("/")
	public String getForm(Model model) {
		return "form";
	}

	@PostMapping("/submit")
	public String PostSubmit(Model model, @RequestParam("nome") String nome, @RequestParam("marca") String marca,
			@RequestParam("prezzo") double prezzo, @RequestParam("immagine") String url) {
		model.addAttribute("nome", nome);
		model.addAttribute("marca", marca);
		model.addAttribute("prezzo", prezzo);
		model.addAttribute("immagine", url);
		listaP.add(new Prodotto(nome, marca, prezzo, url));
		return "submit";
	}

	@PostMapping("/elenco")
	public String getElenco(Model model) {
		model.addAttribute("listaP", listaP);
		return "elenco";
	}

	@PostMapping("/elencocard")
	public String getElencoCard(Model model) {
		model.addAttribute("listaP", listaP);
		return "elencocard";
	}
}
