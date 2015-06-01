package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "tab_kit")
public class Kit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kit")
    private Long id_kit;
    @Column(name = "nome")
    private String nome;
    @ManyToMany
    @JoinTable(name="TAB_KIT_ACESSORIO", joinColumns=
    {@JoinColumn(name="id_kit")}, inverseJoinColumns=
    {@JoinColumn(name="id_acessorio")})
    private List<Acessorio> acessorios;

    public Long getId_kit() {
        return id_kit;
    }

    public void setId_kit(Long id_kit) {
        this.id_kit = id_kit;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

}
