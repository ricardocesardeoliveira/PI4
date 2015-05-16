
package controler;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Marca;
import model.Veiculo;

@Named(value = "veiculoQuiosqueBean")
@SessionScoped
public class VeiculoQuiosqueBean implements Serializable {

    public VeiculoQuiosqueBean() {
        veiculo = new Veiculo();
        marca = new Marca();
    }

    private Veiculo veiculo;
    private Marca marca;
    
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
    
}
