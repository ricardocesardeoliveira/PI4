
package model;

import java.io.Serializable;

public class Relatorio implements Serializable {
    
    public Relatorio() {
    }
    
    public Relatorio(String nomeVeiculo, Integer qtdeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
        this.qtdeVeiculo = qtdeVeiculo;
    }
 
    private String nomeVeiculo;
    private Integer qtdeVeiculo;

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public Integer getQtdeVeiculo() {
        return qtdeVeiculo;
    }

    public void setQtdeVeiculo(Integer qtdeVeiculo) {
        this.qtdeVeiculo = qtdeVeiculo;
    }
    
}
