package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity(name = "TAB_VEICULO")
public class Veiculo implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long id_veiculo;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "MODELO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date modelo;
    @Column(name = "ANO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano;
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
    @JoinColumn(name = "id_Cor")
    private Cor cor;    
    
    @ManyToMany
    @JoinTable(name="TAB_VEICULO_ACESSORIO", joinColumns=
    {@JoinColumn(name="id_veiculo")}, inverseJoinColumns=
    {@JoinColumn(name="id_acessorio")})
    private List<Acessorio> acessorios;

    @ManyToMany
    @JoinTable(name="TAB_VEICULO_KIT", joinColumns=
    {@JoinColumn(name="id_veiculo")}, inverseJoinColumns=
    {@JoinColumn(name="id_kit")})
    private List<Kit> kits;
    
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Long getId() {
        return id_veiculo;
    }

    public void setId(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public Date getModelo() {
        return modelo;
    }

    public void setModelo(Date modelo) {
        this.modelo = modelo;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
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

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }

}
