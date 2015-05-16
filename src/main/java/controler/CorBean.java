
package controler;

import dao.CorDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Cor;

@ManagedBean
@SessionScoped
public class CorBean {
    
    private Cor cor;
    private DataModel listaCores;

    public CorBean() {
        cor = new Cor();
    }
    
    public List<Cor> getCores() {
        List<Cor> lista = new CorDao().list();
        return lista;
    }
    
    public String prepararAlterarCor() {
        cor = (Cor) (listaCores.getRowData());
        return "updateCor";
    }

    public String addCor() throws Exception {
        CorDao corDAO = new CorDao();
        corDAO.save(cor);
        return "index";
    }

     public DataModel listarCores() {
        List<Cor> lista = new CorDao().list();
        listaCores = new ListDataModel(lista);
        return listaCores;
    }
     
    public String excluirCor() {
        Cor corTemp = (Cor) (listaCores.getRowData());
        CorDao dao = new CorDao();
        dao.remove(corTemp);
        return "index";
    }
    
    public String alterarCor() {
        CorDao dao = new CorDao();
        dao.update(cor);
        return "index";
    }
    
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public DataModel getListaCores() {
        return listaCores;
    }

    public void setListaCores(DataModel listaCores) {
        this.listaCores = listaCores;
    }
    
}
