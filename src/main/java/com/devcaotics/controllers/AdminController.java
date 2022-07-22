package com.devcaotics.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devcaotics.model.entities.Cliente;
import com.devcaotics.model.entities.FormaPagamento;
import com.devcaotics.model.entities.Prato;
import com.devcaotics.model.repository.Facade;

@Controller
public class AdminController {
	
	@RequestMapping("/prato/cadastro")
	public String cadastro(Model m, Prato c) {
		
		Facade.getCurrentInstance().createPrato(c);
		
		m.addAttribute("msg","Prato cadastrado com sucesso");
		
		return "index";
		
	}
	
	@RequestMapping("/formaPagamento/cadastro")
	public String cadastro(Model m, FormaPagamento c) {
		
		Facade.getCurrentInstance().createFormaPagamento(c);
		
		m.addAttribute("msg","Prato cadastrado com sucesso");
		
		return "index";
	}

	@RequestMapping("/adm/")
	public String admin(Model m) {
		
		return "/adm/adm";
		
	}

	@RequestMapping("/adm/CadPag")
	public String CadPag (Model m) {
		
		return "/adm/CadPag";

	}
	
	@RequestMapping("/adm/CadPrato")
	public String CadPrato (Model m) {
		
		return "/adm/CadPrato";

	}
	
	@RequestMapping("/adm/VerClientes")
	public String VerClientes(Model m) {
			
			List<Cliente> clientes = Facade.getCurrentInstance().readAllCliente();
			
			m.addAttribute("clientes",clientes);
		
		return "/adm/VerClientes";

	}
	
	@RequestMapping("/adm/VerPedidos")
	public String VerPedidos(Model m) {
		
		return "/adm/VerPedidos";
		
	}

}
