/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.repository;

import com.devcaotics.model.entities.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class CarroRepository implements GenericRepository<Carro, String> {

    CarroRepository(){
        
    }
    
    @Override
    public void create(Carro t) {
        
        String sql = "insert into carro(placa,modelo,cor,fabricante) values(?,?,?,?)";
        
        
        
        try {
            
            PreparedStatement pstm = com.devcaotics.model.
                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, t.getPlaca());
            pstm.setString(2, t.getModelo());
            pstm.setString(3, t.getCor());
            pstm.setString(4, t.getFabricante());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void update(Carro t) {
        String sql = "update carro set modelo = ?, cor = ? ,fabricante=? "
                + "where placa = ? ";
        
        
        
        try {
            
            PreparedStatement pstm = com.devcaotics.model.
                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            
            pstm.setString(1, t.getModelo());
            pstm.setString(2, t.getCor());
            pstm.setString(3, t.getFabricante());
            
            pstm.setString(4, t.getPlaca());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Carro read(String i) {
        
        String sql = "select * from carro where placa=?";
        
        try {
            
            PreparedStatement pstm = com.devcaotics.model.
                    dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            
            pstm.setString(1, i);
            
            ResultSet result = pstm.executeQuery();
            
            if(result.next()){
                Carro c =  new Carro();
                c.setPlaca(i);
                c.setModelo(result.getString("modelo"));
                c.setCor(result.getString("cor"));
                c.setFabricante(result.getString("fabricante"));
                
                return c;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void delete(String i) {
        
        String sql = "delete from carro where placa = ?";
        
        try {
            
            PreparedStatement pstm = com.devcaotics.model.
                dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, i);
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Carro> readAll() {
        
        String sql = "select * from carro";
        
        List<Carro> carros = new ArrayList<>();
        
        try {
            
            PreparedStatement pstm = com.devcaotics.model.
                    dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
            
            ResultSet result = pstm.executeQuery();
            
            
            
           while(result.next()){
                Carro c =  new Carro();
                c.setPlaca(result.getString("placa"));
                c.setModelo(result.getString("modelo"));
                c.setCor(result.getString("cor"));
                c.setFabricante(result.getString("fabricante"));
                
                carros.add(c);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return carros;
    
    }
    
    
    public static void main(String args[]){
        
        /*Carro c = new Carro();
        
        c.setPlaca("kct-3323");
        c.setModelo("opala");
        c.setCor("bege");
        c.setFabricante("chevorusut");*/
        
        CarroRepository cr = new CarroRepository();
        List<Carro> cars = cr.readAll();
        
        System.out.println(cars.size());
        
       
                
        
    }
    
}
