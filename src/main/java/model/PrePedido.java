
package model;

import java.io.Serializable;
import java.util.Date;
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
    private String preco;
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

}
