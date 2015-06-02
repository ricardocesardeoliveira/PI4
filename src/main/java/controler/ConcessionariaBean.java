package controler;

import dao.ConcessionariaDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Concessionaria;

@ManagedBean
@RequestScoped
public class ConcessionariaBean {
    
    private Concessionaria concessionaria;
    private DataModel listaConcessionarias;
    private List<Concessionaria> lista;
    private List<Concessionaria> listaConcessionariasSelecionadas;
    
    public ConcessionariaBean() {
        concessionaria = new Concessionaria();
        listaConcessionariasSelecionadas = new ArrayList<>();
    }
    
    public String prepararAlterarConcessionaria() {
        concessionaria = (Concessionaria) (listaConcessionarias.getRowData());
        return "updateConcessionaria";
    }

    public String addConcessionaria() throws Exception {
        ConcessionariaDao concessionariaDAO = new ConcessionariaDao();
        concessionariaDAO.save(concessionaria);
        return "listaConcessionarias";
    }

     public DataModel listarConcessionarias() {
        List<Concessionaria> lista = new ConcessionariaDao().list();
        listaConcessionarias = new ListDataModel(lista);
        return listaConcessionarias;
    }
     
    public String excluirConcessionaria() {
        Concessionaria marcaTemp = (Concessionaria) (listaConcessionarias.getRowData());
        ConcessionariaDao dao = new ConcessionariaDao();
        dao.remove(marcaTemp);
        return "listaConcessionarias";
    }
    
    public String alterarConcessionaria() {
        ConcessionariaDao dao = new ConcessionariaDao();
        dao.update(concessionaria);
        return "listaConcessionarias";
    }

    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public DataModel getListaConcessionarias() {
        return listaConcessionarias;
    }

    public void setListaConcessionarias(DataModel listaConcessionarias) {
        this.listaConcessionarias = listaConcessionarias;
    }

    public List<Concessionaria> getLista() {
        List<Concessionaria> lista = new ConcessionariaDao().list();
        this.lista = lista;
        return this.lista;
    }

    public void setLista(List<Concessionaria> lista) {
        this.lista = lista;
    }

    public List<Concessionaria> getListaConcessionariasSelecionadas() {
        return listaConcessionariasSelecionadas;
    }

    public void setListaConcessionariasSelecionadas(List<Concessionaria> listaConcessionariasSelecionadas) {
        this.listaConcessionariasSelecionadas = listaConcessionariasSelecionadas;
    }

}
