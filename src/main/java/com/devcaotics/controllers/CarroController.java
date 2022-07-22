package com.devcaotics.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devcaotics.model.entities.Carro;
import com.devcaotics.model.entities.Prato;
import com.devcaotics.model.repository.Facade;

@Controller
public class CarroController {
	@RequestMapping("/")
	public String index(Model m) {
		List<Prato> carros = Facade.getCurrentInstance().readAllPrato();
		
		m.addAttribute("pratos",carros);
		return "index";
		
	}
	
	@RequestMapping("/login")
	public String login(Model m) {
		
		return "login";
		
	}
	
	
	@RequestMapping("/registro")
	public String registro(Model m) {
		
		return "registro";
		
	}
	
	@RequestMapping("/carro/telaCadastro")
	public String telaCadastro(Model m) {
		
		return "carro/cadastro";
	}
	
	@RequestMapping("/carro/cadastro")
	public String cadastro(Model m, Carro c) {
		
		Facade.getCurrentInstance().create(c);
		
		m.addAttribute("msg","Carro cadastrado com sucesso");
		
		return "index";
		
	}
	
	@RequestMapping("/carro/list")
	public String listar(Model m) {
		
		List<Carro> carros = Facade.getCurrentInstance().readAllCarro();
		
		m.addAttribute("carros",carros);
		
		return "carro/carros";
	
	}
	
	@RequestMapping("/carro/visualiza/{placa}")
	public String visualiza(Model m, @PathVariable("placa") String placa) {
		
		Carro c = Facade.getCurrentInstance().readCarro(placa);
		
		m.addAttribute("carro", c);
		
		return "carro/carro";
		
	}
	

}
