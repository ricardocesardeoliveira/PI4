
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.*;

@Entity(name = "TAB_PRE_PEDIDO")
public class PrePedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pre_pedido")
    private Long id_pre_pedido;    
    @Column(name = "dia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dia;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "status")
    private String status;
    @Column(name = "regiao")
    private String regiao;
    @Column(name = "comissao")
    private Double comissao;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @ManyToMany
    @JoinTable(name="TAB_PrePedido_Concessionaria", joinColumns=
    {@JoinColumn(name="id_pre_pedido")}, inverseJoinColumns=
    {@JoinColumn(name="id_concessionaria")})
    private List<Concessionaria> concessionarias;

    public Long getId() {
        return id_pre_pedido;
    }

    public void setId(Long id_pre_pedido) {
        this.id_pre_pedido = id_pre_pedido;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Long getId_pre_pedido() {
        return id_pre_pedido;
    }

    public void setId_pre_pedido(Long id_pre_pedido) {
        this.id_pre_pedido = id_pre_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public List<Concessionaria> getConcessionarias() {
        return concessionarias;
    }

    public void setConcessionarias(List<Concessionaria> concessionarias) {
        this.concessionarias = concessionarias;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
}
