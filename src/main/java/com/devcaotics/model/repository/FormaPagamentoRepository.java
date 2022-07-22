package com.devcaotics.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.devcaotics.model.entities.Cliente;
import com.devcaotics.model.entities.FormaPagamento;

public class FormaPagamentoRepository implements GenericRepository<FormaPagamento, String> {

	@Override
	public void create(FormaPagamento t) {
		 String sql = "insert into formapagamento(descricao) values(?)";
	        
	        
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setString(1, t.getDescricao());
	       

	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
	        }		
	}

	@Override
	public void update(FormaPagamento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FormaPagamento read(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FormaPagamento> readAll() {
		// TODO Auto-generated method stub
		  String sql = "select * from formapagamento";
	        
	        List<FormaPagamento> carros = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = com.devcaotics.model.
	                    dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            
	            ResultSet result = pstm.executeQuery();
	            
	            
	            
	           while(result.next()){
	                FormaPagamento c =  new FormaPagamento();
	                c.setDescricao(result.getString("descricao"));


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
