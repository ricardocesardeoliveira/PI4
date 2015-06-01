package controler;

import dao.MarcaDao;
import java.io.Serializable;
import java.util.List;
import model.Marca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MarcaBean  implements Serializable {

    private Marca marca;
    private DataModel listaMarcas;

    public MarcaBean() {
        marca = new Marca();
    }
    public List<Marca> getMarcas() {
        List<Marca> lista = new MarcaDao().list();
        return lista;
    }
    
    public String prepararAlterarMarca() {
        marca = (Marca) (listaMarcas.getRowData());
        return "updateMarca";
    }

    public String addMarca() throws Exception {
        MarcaDao marcaDAO = new MarcaDao();
        marcaDAO.save(marca);
        return "listaMarcas";
    }

     public DataModel listarMarcas() {
        List<Marca> lista = new MarcaDao().list();
        listaMarcas = new ListDataModel(lista);
        return listaMarcas;
    }
     
    public String excluirMarca() {
        Marca marcaTemp = (Marca) (listaMarcas.getRowData());
        MarcaDao dao = new MarcaDao();
        dao.remove(marcaTemp);
        return "listaMarcas";
    }
    
    public String alterarMarca() {
        MarcaDao dao = new MarcaDao();
        dao.update(marca);
        return "listaMarcas";
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public DataModel getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(DataModel listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

}
