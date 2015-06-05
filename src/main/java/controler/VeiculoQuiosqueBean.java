
package controler;

import dao.VeiculoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import model.Veiculo;

@Named(value = "veiculoQuiosqueBean")
@SessionScoped
public class VeiculoQuiosqueBean implements Serializable {

    public VeiculoQuiosqueBean() {
        veiculo = new Veiculo();
        marca = new Marca();
        listaFiat = new ArrayList<>();
    }

    private Veiculo veiculo;
    private Marca marca;
    private String valorPesquisa;
    private Veiculo veiculoSelecionado;
    private List<Veiculo> veiculoSelecionados;
    
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
        listaFiat = new VeiculoDao().listVeiculosFiat();
        return listaFiat;
    }
    
    public void veiculosFiatFilter() {
        listaFiat = new VeiculoDao().listVeiculosFiatFilter(valorPesquisa);
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

    public String getValorPesquisa() {
        return valorPesquisa;
    }

    public void setValorPesquisa(String valorPesquisa) {
        this.valorPesquisa = valorPesquisa;
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

}
