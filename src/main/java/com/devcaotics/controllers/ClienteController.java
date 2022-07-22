package com.devcaotics.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devcaotics.model.entities.Carro;
import com.devcaotics.model.entities.Cliente;
import com.devcaotics.model.repository.Facade;

@Controller
public class ClienteController {

	@RequestMapping("/cliente/cadastro")
	public String cadastro(Model m, Cliente c) {
		
		Facade.getCurrentInstance().createCliente(c);
		
		m.addAttribute("msg","Cliente cadastrado com sucesso");
		
		return "index";
		
	}
	

}
