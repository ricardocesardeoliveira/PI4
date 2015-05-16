package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TAB_VEICULO")
public class Veiculo implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANO")
    private String ano;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "PRECO")
    private String preco;
    @Column(name = "MOTOR")
    private String motor;
    
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    
    @Column(name = "IMG_PRINCIPAL")
    private String img_princial;
    
    
    @ManyToOne
    @JoinColumn(name = "idCor")
    private Cor cor;    
    
//    private List<Acessorio> acessorios;

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getImg_princial() {
        return img_princial;
    }

    public void setImg_princial(String img_princial) {
        this.img_princial = img_princial;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
