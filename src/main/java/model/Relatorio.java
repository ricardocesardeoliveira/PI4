
package model;

import java.io.Serializable;

public class Relatorio implements Serializable {
    
    public Relatorio() {
    }
    
    public Relatorio(String nomeVeiculo, Long qtdeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
        this.qtdeVeiculo = qtdeVeiculo;
    }
 
    private String nomeVeiculo;
    private Long qtdeVeiculo;

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public Long getQtdeVeiculo() {
        return qtdeVeiculo;
    }

    public void setQtdeVeiculo(Long qtdeVeiculo) {
        this.qtdeVeiculo = qtdeVeiculo;
    }
    
}
