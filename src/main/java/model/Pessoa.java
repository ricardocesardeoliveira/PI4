package model;

import java.io.Serializable;
//import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity(name = "tab_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long id_pessoa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nasc")
    private String data_nasc;
    @Column(name = "eMail")
    private String eMail;
    @Column(name = "password")
    private String password;
    @Column(name = "idade")
    private Integer idade;

//    @Temporal(TemporalType.DATE)
//    private Date data_nasc;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getId_pessoa() {
        return id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

//    public Date getData_nasc() {
//        return data_nasc;
//    }
    public String getData_nasc() {
        return data_nasc;
    }

    @MapsId
    public Endereco getEndereco() {
        return endereco;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

//    public void setData_nasc(Date data_nasc) {
//        this.data_nasc = data_nasc;
//    }
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
}
