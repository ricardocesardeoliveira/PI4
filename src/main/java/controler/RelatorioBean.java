/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "relatorioBean")
@Dependent
public class RelatorioBean  implements Serializable{
    
    public RelatorioBean() {
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
