
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tab_acessorio")
public class Acessorio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acessorio")
    private Long id_acessorio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private double valor;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_veiculo")
    @ManyToOne(cascade=CascadeType.ALL)
    private Veiculo veiculo;

    public Long getId_acessorio() {
        return id_acessorio;
    }

    public void setId_acessorio(Long id_acessorio) {
        this.id_acessorio = id_acessorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}
