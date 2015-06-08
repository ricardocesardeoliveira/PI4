/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.PessoaDao;
import dao.PrePedidoDao;
import dao.RelatorioDao;
import dao.VeiculoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pessoa;
import model.PrePedido;
import model.Relatorio;
import model.Veiculo;

@Named(value = "relatorioBean")
@RequestScoped
public class RelatorioBean  implements Serializable{
    
    private List<Relatorio> relatorios;
    
    public RelatorioBean() {
        this.relatorios = new ArrayList<>();
    }
    
    public List<Relatorio> getRelatorio18a28() {
        List<Relatorio> listaRelatorio = new ArrayList<>();
        List<PrePedido> listaPrePedido18a28 = new ArrayList<>();
        
        for (PrePedido prePedido : new PrePedidoDao().list()) {
            if ( (prePedido.getPessoa().getIdade() >= 18) &&  (prePedido.getPessoa().getIdade() <= 28) ){
                listaPrePedido18a28.add(prePedido);
            }
        }
        
        for (Veiculo veiculo : new VeiculoDao().list()) {
            if (Collections.frequency(listaPrePedido18a28, veiculo) > 0) {
                
            }
        }
        
        return listaRelatorio;
    }
    
    
    
    
    
//    private List<Car> cars;
//         
//    @ManagedProperty("#{carService}")
//    private CarService service;
//     
//    @PostConstruct
//    public void init() {
//        cars = service.createCars(100);
//    }
// 
//    public List<Car> getCars() {
//        return cars;
//    }
// 
//    public void setService(CarService service) {
//        this.service = service;
//    }

    public List<Relatorio> getRelatorios() {
        relatorios = new RelatorioDao().listarVeiculosMaisVendidos();
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }
    
    
    
}
