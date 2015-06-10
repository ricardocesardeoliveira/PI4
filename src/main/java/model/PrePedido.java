
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
    private BigDecimal comissao;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "id_concessionaria1")
    private Concessionaria concessionaria1;
    @ManyToOne
    @JoinColumn(name = "id_concessionaria2")
    private Concessionaria concessionaria2;
    @ManyToOne
    @JoinColumn(name = "id_concessionaria3")
    private Concessionaria concessionaria4;

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

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Concessionaria getConcessionaria1() {
        return concessionaria1;
    }

    public void setConcessionaria1(Concessionaria concessionaria1) {
        this.concessionaria1 = concessionaria1;
    }

    public Concessionaria getConcessionaria2() {
        return concessionaria2;
    }

    public void setConcessionaria2(Concessionaria concessionaria2) {
        this.concessionaria2 = concessionaria2;
    }

    public Concessionaria getConcessionaria4() {
        return concessionaria4;
    }

    public void setConcessionaria4(Concessionaria concessionaria4) {
        this.concessionaria4 = concessionaria4;
    }
    
}
