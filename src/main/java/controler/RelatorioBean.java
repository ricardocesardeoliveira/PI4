/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.PessoaDao;
import dao.PrePedidoDao;
import dao.RelatorioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pessoa;
import model.PrePedido;
import model.Relatorio;

@Named(value = "relatorioBean")
@RequestScoped
public class RelatorioBean  implements Serializable{
    
    public RelatorioBean() {
    }
    
    public List<Relatorio> getLista() {
        List<Relatorio> listaRelatorio = new ArrayList<>();
        List<PrePedido> listaPrePedido = new PrePedidoDao().list();
        
        for (PrePedido prePedido : listaPrePedido) {
            int dataNacimento = Integer.valueOf(prePedido.getPessoa().getData_nasc().substring(12));
            if (dataNacimento > new Date().getYear()) {
                listaRelatorio.add(new Relatorio());
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
    
}
