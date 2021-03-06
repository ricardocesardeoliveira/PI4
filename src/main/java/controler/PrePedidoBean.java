
package controler;

import dao.CorDao;
import dao.PrePedidoDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Scope;
import model.Acessorio;
import model.PrePedido;

@Named(value = "prePedidoBean")
@RequestScoped
public class PrePedidoBean  implements Serializable {

    private PrePedido prePedido;
    private PrePedido prePedidoSelecionado;
    private DataModel listaPrePedidos;
    private List<PrePedido> lista;
    

    public PrePedidoBean() {
        prePedido = new PrePedido();
    }
    
    public String prepararAlterarPrePedido() {
        prePedido = (PrePedido) (listaPrePedidos.getRowData());
        return "updatePrePedido";
    }

    public String addPrePedido() throws Exception {
        PrePedidoDao prePedidoDao = new PrePedidoDao();
        prePedidoDao.save(prePedido);
        return "listaPrePedidos";
    }

     public DataModel listarPrePedidos() {
        List<PrePedido> lista = new PrePedidoDao().list();
        listaPrePedidos = new ListDataModel(lista);
        return listaPrePedidos;
    }
     
    public String excluirPrePedido() {
       PrePedido prePedidoTemp = (PrePedido) (listaPrePedidos.getRowData());
        PrePedidoDao dao = new PrePedidoDao();
        dao.remove(prePedidoTemp);
        return "listaPrePedido";
    }
    
    public String alterarPrePedido() {
        PrePedidoDao dao = new PrePedidoDao();
        dao.update(prePedido);
        return "listaPrePedidos";
    }

    public PrePedido getPrePedido() {
        return prePedido;
    }

    public void setPrePedido(PrePedido prePedido) {
        this.prePedido = prePedido;
    }

    public DataModel getListaPrePedidos() {
        return listaPrePedidos;
    }

    public void setListaAcessorios(DataModel listaPrePedidos) {
        this.listaPrePedidos = listaPrePedidos;
    }

    public List<PrePedido> getLista() {
        List<PrePedido> lista = new PrePedidoDao().list();
        this.lista = lista;
        return this.lista;
    }

    public void setLista(List<PrePedido> lista) {
        this.lista = lista;
    }

    public PrePedido getPrePedidoSelecionado() {
        return prePedidoSelecionado;
    }

    public void setPrePedidoSelecionado(PrePedido prePedidoSelecionado) {
        this.prePedidoSelecionado = prePedidoSelecionado;
    }
    
    public String finalizarPrePedido() {
        prePedidoSelecionado.setStatus("Fechado");
//        double valorTotalAcessorios = 0;
//        for (Acessorio acessorio : prePedidoSelecionado.getVeiculo().getAcessorios()) {
//            valorTotalAcessorios += acessorio.getValor().doubleValue();
//        }
        prePedidoSelecionado.setComissao( BigDecimal.valueOf((prePedidoSelecionado.getVeiculo().getPreco().doubleValue() * 4) / 100) );
//      zprePedido.setPreco( BigDecimal.valueOf(prePedidoSelecionado.getVeiculo().getPreco().doubleValue() + valorTotalAcessorios) );
        prePedido.setPreco(prePedidoSelecionado.getVeiculo().getPreco());
        PrePedidoDao dao = new PrePedidoDao();
        dao.update(prePedidoSelecionado);
        return "indexConcessionaria";
    }

}
