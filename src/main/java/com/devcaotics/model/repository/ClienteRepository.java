package com.devcaotics.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.devcaotics.model.entities.Cliente;

public class ClienteRepository implements GenericRepository<Cliente, String> {

	@Override
	public void create(Cliente t) {
		 String sql = "insert into cliente(cpf,nome,telefone,email,senha) values(?,?,?,?,?)";
	        
	        
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setString(1, t.getCpf());
	            pstm.setString(2, t.getNome());
	            pstm.setString(3, t.getTelefone());
	            pstm.setString(4, t.getEmail());
	            pstm.setString(5, t.getSenha());

	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }		
	}

	@Override
	public void update(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente read(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> readAll() {
		// TODO Auto-generated method stub
		  String sql = "select * from cliente";
	        
	        List<Cliente> carros = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                    dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            ResultSet result = pstm.executeQuery();
	            
	            
	            
	           while(result.next()){
	                Cliente c =  new Cliente();
	                c.setCpf(result.getString("cpf"));
	                c.setNome(result.getString("nome"));
	                c.setTelefone(result.getString("telefone"));
	                c.setEmail(result.getString("email"));
	                c.setSenha(result.getString("senha"));

	                carros.add(c);
	            }
	            
	            
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return carros;
	}

}
