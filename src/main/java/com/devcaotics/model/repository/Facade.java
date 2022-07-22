/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.repository;

import com.devcaotics.model.entities.Carro;
import com.devcaotics.model.entities.Cliente;
import com.devcaotics.model.entities.FormaPagamento;
import com.devcaotics.model.entities.Motorista;
import com.devcaotics.model.entities.Prato;

import java.util.List;

/**
 *
 * @author ALUNO
 */
public class Facade {
    
    private static Facade myself = null;
    
    private GenericRepository<Carro, String> rCarro = null; 
    private GenericRepository<Cliente, String> rCliente = null; 
    private GenericRepository<Prato, String> rPrato = null; 
    private GenericRepository<FormaPagamento, String> rFormaPagamento = null; 

    private Facade(){
        
        this.rCarro = new CarroRepository();
        this.rCliente = new ClienteRepository();
        this.rPrato = new PratoRepository();
        this.rFormaPagamento = new FormaPagamentoRepository();

    }
    
    public static Facade getCurrentInstance(){
        
        if(myself == null){
            myself = new Facade();
        }
        
        return myself;
        
    }
    
    public void create(Carro c){
        this.rCarro.create(c);
    }
    
    public void createCliente(Cliente c){
        this.rCliente.create(c);
    }
    
    public void createPrato(Prato c){
        this.rPrato.create(c);
    }
    
    
    public void createFormaPagamento(FormaPagamento c){
        this.rFormaPagamento.create(c);
    }
    
    
    public void update(Carro c){
        this.rCarro.update(c);
    }
    
    public Carro readCarro(String placa){
    	
       return this.rCarro.read(placa);
    }
    
    public void deleteCarro(String placa){
        this.rCarro.delete(placa);
    }
    
    public List<Carro> readAllCarro(){
        return this.rCarro.readAll();
    }
    public List<Cliente> readAllCliente(){
        return this.rCliente.readAll();
    }
    public List<Prato> readAllPrato(){
        return this.rPrato.readAll();
    }
    
    public List<Prato> readAllFormaDescricao(){
        return this.rPrato.readAll();
    }
    
    
    
}
