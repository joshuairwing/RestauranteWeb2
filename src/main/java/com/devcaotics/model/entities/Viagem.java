/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.entities;

import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class Viagem {
    
    private int id;
    private long data;
    private String origem;
    private String destino;
    private String motivo;
    
    private Carro veiculo;
    private Motorista motorista;
    
    private double quilometragemVeiculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return new Date(this.data);
    }

    public void setData(Date data) {
        this.data = data.getTime();
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Carro getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Carro veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public double getQuilometragemVeiculo() {
        return quilometragemVeiculo;
    }

    public void setQuilometragemVeiculo(double quilometragemVeiculo) {
        this.quilometragemVeiculo = quilometragemVeiculo;
    }
    
    
    
}
