
package model;

import java.io.Serializable;

public class Relatorio implements Serializable {
    
    public Relatorio() {
    }
    
    public Relatorio(String nomeVeiculo, String qtdeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
        this.qtdeVeiculo = qtdeVeiculo;
    }
 
    private String nomeVeiculo;
    private String qtdeVeiculo;

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getQtdeVeiculo() {
        return qtdeVeiculo;
    }

    public void setQtdeVeiculo(String qtdeVeiculo) {
        this.qtdeVeiculo = qtdeVeiculo;
    }
    
}
