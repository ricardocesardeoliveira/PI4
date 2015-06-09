
package model;

import java.io.Serializable;

public class RelatorioFaixaIdade implements Serializable {
    
    public RelatorioFaixaIdade() {
    }
    
    public RelatorioFaixaIdade(String nomeVeiculo, String nomeFabricante, Long qtdeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
        this.nomeFabricante = nomeFabricante;
        this.qtdeVeiculo = qtdeVeiculo;
    }
 
    private String nomeVeiculo;
    private String nomeFabricante;
    private String faixaIdade;
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

    public String getNomeFabricante() {
        return nomeFabricante;
    }

    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }

    public String getFaixaIdade() {
        return faixaIdade;
    }

    public void setFaixaIdade(String faixaIdade) {
        this.faixaIdade = faixaIdade;
    }
    
}
