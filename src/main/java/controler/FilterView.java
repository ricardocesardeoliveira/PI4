
package controler;

import dao.VeiculoDao;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;import model.Veiculo;
 
@ManagedBean(name="dtFilterView")
@ViewScoped
public class FilterView implements Serializable {
     
    private List<Veiculo> cars;
     
    private List<Veiculo> filteredCars;
 
    @PostConstruct
    public void init() {
        cars = new VeiculoDao().list();
    }
     
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
     
    public List<Veiculo> getCars() {
        return cars;
    }
 
    public List<Veiculo> getFilteredCars() {
        return filteredCars;
    }
 
    public void setFilteredCars(List<Veiculo> filteredCars) {
        this.filteredCars = filteredCars;
    }

}