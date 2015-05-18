/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.VeiculoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Cor;
import model.Marca;
import model.Veiculo;

@ManagedBean
@SessionScoped
public class VeiculoBean {
    
    private Veiculo veiculo;
    private List<Veiculo> lista;
    private Cor cor;
    private Marca marca;
    private DataModel listaVeiculos;


     public VeiculoBean () {
         veiculo = new Veiculo();
         marca = new Marca();
         cor = new Cor();
     }
 
     public String prepararAlterarPessoa() {
         veiculo = (Veiculo) (listaVeiculos.getRowData());
         return "updateVeiculo";
     }
 
     public String addVeiculo() throws Exception {
        VeiculoDao veiculoDAO = new VeiculoDao();
        veiculo.setMarca(marca);
        veiculo.setCor(cor);
        veiculoDAO.save(veiculo);
        return "listaVeiculos";
     }
 
     public DataModel listarVeiculos() {
         List<Veiculo> lista = new VeiculoDao().list();
         listaVeiculos = new ListDataModel(lista);
         return listaVeiculos;
     }
 
     public String excluirVeiculo() {
         Veiculo veiculoTemp = (Veiculo) (listaVeiculos.getRowData());
         VeiculoDao dao = new VeiculoDao();
         dao.remove(veiculoTemp);
         listarVeiculos();
         return "listaVeiculos";
     }
 
     public String alterarVeiculo() {
         VeiculoDao dao = new VeiculoDao();
         dao.update(veiculo);
         return "index";
     }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public DataModel getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(DataModel listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Veiculo> getLista() {
        List<Veiculo> lista = new VeiculoDao().list();
        this.lista = lista;
        return this.lista;
    }

    public void setLista(List<Veiculo> lista) {
        this.lista = lista;
    }
    
    
 
}
