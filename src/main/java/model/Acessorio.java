
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_acessorio")
public class Acessorio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acessorio")
    private Long id_acessorio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "imagem")
    private String imagem;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
}
