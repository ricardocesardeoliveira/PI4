package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_concessionaria")
public class Concessionaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_concessionaria")
    private Long id_concessionaria;
    @Column(name = "nome")
    private String nome;
    @Column(name = "regiao")
    private String regiao;
    @Column(name = "password")
    private String password;

    public Long getId_concessionaria() {
        return id_concessionaria;
    }

    public void setId_concessionaria(Long id_concessionaria) {
        this.id_concessionaria = id_concessionaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}
