
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_cor")
public class Cor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cor")
    private Integer id_cor;
    @Column(name = "nome")
    private String nome;

    public Integer getIdCor() {
        return id_cor;
    }

    public void setIdCor(Integer id_cor) {
        this.id_cor = id_cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
