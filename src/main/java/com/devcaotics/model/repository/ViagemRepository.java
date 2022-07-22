/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.repository;

import com.devcaotics.model.dao.ConnectionManager;
import com.devcaotics.model.entities.Carro;
import com.devcaotics.model.entities.Motorista;
import com.devcaotics.model.entities.Viagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class ViagemRepository implements GenericRepository<Viagem, Integer>{

    @Override
    public void create(Viagem t) {
        
        String sql = "insert into viagem(data, origem, destino, "
                + "motivo,placa_carro,cpf_motorista) values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setLong(1, t.getData().getTime());
            pstm.setString(2, t.getOrigem());
            pstm.setString(3, t.getDestino());
            pstm.setString(4, t.getMotivo());
            
            pstm.setString(5, t.getVeiculo().getPlaca());
            pstm.setString(6, t.getMotorista().getCpf());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Viagem t) {
        String sql = "update set viagem(origem = ?, destino = ?, "
                + "motivo = ?) where id_viagem = ? ";
        
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setString(1, t.getOrigem());
            pstm.setString(2, t.getDestino());
            pstm.setString(3, t.getMotivo());
            
            pstm.setLong(4, t.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Viagem read(Integer i) {
        String sql = "select * from viagem as v join carro as c join motorista as m "
                + "on (v.placa_carro = c.placa and v.cpf_motorista = m.cpf) where viagem = ?";
        
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, i);
            
            ResultSet r = pstm.executeQuery();
            
            if(r.next()){
                
                Carro c = new Carro();
                c.setPlaca(r.getString("placa"));
                c.setModelo(r.getString("modelo"));
                c.setFabricante(r.getString("fabricante"));
                c.setCor(r.getString("cor"));
                
                Motorista m = new Motorista();
                m.setCnh(r.getString("cnh"));
                m.setCpf(r.getString("cpf"));
                
                Viagem v = new Viagem();
                
                v.setData(new Date(r.getLong("data")));
                v.setDestino(r.getString("destino"));
                v.setId(r.getInt("id_viagem"));
                v.setMotivo(r.getString("motivo"));
                v.setOrigem(r.getString("origem"));
                
                v.setVeiculo(c);
                v.setMotorista(m);
                
                return v;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void delete(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Viagem> readAll() {
        
        String sql = "select * from viagem";
        
        List<Viagem> viagens = new ArrayList<>();
        
        try {
            
            PreparedStatement pstm = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            ResultSet r = pstm.executeQuery();
            
            while(r.next()){
                
                Viagem v = new Viagem();
                
                v.setData(new Date(r.getLong("data")));
                v.setDestino(r.getString("destino"));
                v.setId(r.getInt("id_viagem"));
                v.setMotivo(r.getString("motivo"));
                v.setOrigem(r.getString("origem"));
                
                String sql2 = "select * from carro where placa = ?";
                
                PreparedStatement pstm2 = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql2);
                
                pstm2.setString(1, r.getString("placa_carro"));
                
                ResultSet r2 = pstm2.executeQuery(sql2);
                
                if(r2.next()){
                    Carro c = new Carro();
                    
                    c.setPlaca(r2.getString("placa"));
                    c.setFabricante(r2.getString("fabricante"));
                    c.setModelo(r2.getString("modelo"));
                    c.setCor(r2.getString("cor"));
                    
                    v.setVeiculo(c);
                    
                }
                
                String sql3 = "select * from motorista where cpf = ?";
                
                PreparedStatement pstm3 = ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql3);
                
                pstm3.setString(1, r.getString("cpf_motorista"));
                
                ResultSet r3 = pstm3.executeQuery(sql3);
                
                if(r3.next()){
                    Motorista m = new Motorista();
                    
                    m.setCpf(r3.getString("cpf"));
                    //faz o resto
                    
                    v.setMotorista(m);
                    
                }
                
                viagens.add(v);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViagemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return viagens;
    }
    
}
