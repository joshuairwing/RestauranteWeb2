package com.devcaotics.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.devcaotics.model.entities.Cliente;
import com.devcaotics.model.entities.Prato;

public class PratoRepository implements GenericRepository<Prato, String> {

	@Override
	public void create(Prato t) {
		 String sql = "insert into prato(nome,descricao,preco) values(?,?,?)";
	        
	        
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setString(1, t.getNome());
	            pstm.setString(2, t.getDescricao());
	            pstm.setDouble(3, t.getPreco());

	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }		
	}

	@Override
	public void update(Prato t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prato read(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prato> readAll() {
		// TODO Auto-generated method stub
		  String sql = "select * from prato";
	        
	        List<Prato> carros = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                    dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            ResultSet result = pstm.executeQuery();
	            
	            
	            
	           while(result.next()){
	        	   Prato c =  new Prato();
	                c.setNome(result.getString("nome"));
	                c.setDescricao(result.getString("descricao"));
	                c.setPreco(result.getDouble("preco"));

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
