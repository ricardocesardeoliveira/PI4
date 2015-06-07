
package controler;

import dao.AcessorioDao;
import dao.VeiculoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Acessorio;
import model.Concessionaria;
import model.Marca;
import model.Veiculo;

@Named(value = "veiculoQuiosqueBean")
@SessionScoped
public class VeiculoQuiosqueBean implements Serializable {

    public VeiculoQuiosqueBean() {
        veiculo = new Veiculo();
        marca = new Marca();
        listaFiat = new ArrayList<>();
//        veiculoSelecionados = new ArrayList<>();
        listaAcessorios = new ArrayList<>();
    }

    private Veiculo veiculo;
    private Marca marca;
    private Veiculo veiculoSelecionado;
    private List<Veiculo> veiculoSelecionados;
    private List<Acessorio> listaAcessorios;
    private List<Acessorio> listaAcessoriosSelecionados;
    private List<Concessionaria> listaConcessionariasSelecionadas;
    private List<Veiculo> listaFiat;
    
    public String setarMarcaBMW(){
        this.marca.setNome("BMW");
        return "veiculos-bmw";
    }
    
    public String setarMarcaFiat(){
        this.marca.setNome("Fiat");
        return "veiculos-fiat";
    }
    
    public String setarMarcaNissan(){
        this.marca.setNome("Nissan");
        return "veiculos-nissan";
    }
    
    public String setarMarcaToyota(){
        this.marca.setNome("Toyota");
        return "veiculos-toyota";
    }
    
    public String setarMarcaVW(){
        this.marca.setNome("VolksWagen");
        return "veiculos-volkswagen";
    }
    
    
    public List<Veiculo> getVeiculosFiat() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosFiat();
        return lista;
    }
    
    public List<Veiculo> getVeiculosVW() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosVW();
        return lista;
    }
    
    public List<Veiculo> getVeiculosBMW() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosBMW();
        return lista;
    }
    
    public List<Veiculo> getVeiculosNissan() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosNissan();
        return lista;
    }
    
    public List<Veiculo> getVeiculosToyota() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosToyota();
        return lista;
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }

    public List<Veiculo> getVeiculoSelecionados() {
        return veiculoSelecionados;
    }

    public void setVeiculoSelecionados(List<Veiculo> veiculoSelecionados) {
        this.veiculoSelecionados = veiculoSelecionados;
    }

    public List<Veiculo> getListaFiat() {
        return listaFiat;
    }

    public void setListaFiat(List<Veiculo> listaFiat) {
        this.listaFiat = listaFiat;
    }

    public String setarVeiculo(Long idVeiclulo){
        List<Veiculo> lista = new VeiculoDao().list();
        for (Veiculo veiculo : lista) {
            if (veiculo.getId_veiculo().equals(idVeiclulo)) {
                this.veiculo = veiculo;
            }
        }
        return "addAcessorioQuiosque";
    }
    
    public String adicionarAcessorios(){
        this.veiculo.setAcessorios(listaAcessorios);
        return "concessionaria-new";
    }

    public List<Acessorio> getListaAcessorios() {
        listaAcessorios = new AcessorioDao().list();
        return listaAcessorios;
    }

    public void setListaAcessorios(List<Acessorio> listaAcessorios) {
        this.listaAcessorios = listaAcessorios;
    }

    public List<Acessorio> getListaAcessoriosSelecionados() {
        return listaAcessoriosSelecionados;
    }

    public void setListaAcessoriosSelecionados(List<Acessorio> listaAcessoriosSelecionados) {
        this.listaAcessoriosSelecionados = listaAcessoriosSelecionados;
    }

    public List<Concessionaria> getListaConcessionariasSelecionadas() {
        return listaConcessionariasSelecionadas;
    }

    public void setListaConcessionariasSelecionadas(List<Concessionaria> listaConcessionariasSelecionadas) {
        this.listaConcessionariasSelecionadas = listaConcessionariasSelecionadas;
    }
    
    public String gerarPrepedido() {
        return "indexQuiosque";
    } 
    
}
