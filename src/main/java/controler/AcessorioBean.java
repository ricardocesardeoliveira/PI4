
package controler;

import dao.AcessorioDao;
import dao.VeiculoDao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Acessorio;
import model.Veiculo;

@Named(value = "acessorioBean")
@RequestScoped
public class AcessorioBean  implements Serializable {

    private Acessorio acessorio;
    private DataModel listaAcessorios;
    private List<Acessorio> listaAcessoriosQuiosque;

    public AcessorioBean() {
        acessorio = new Acessorio();
    }
    
    public String prepararAlterarAcessorio() {
        acessorio = (Acessorio) (listaAcessorios.getRowData());
        return "updateAcessorio";
    }

    public String addAcessorio() throws Exception {
        AcessorioDao acessorioDao = new AcessorioDao();
        acessorioDao.save(acessorio);
        return "listaAcessorios";
    }

     public DataModel listarAcessorios() {
        List<Acessorio> lista = new AcessorioDao().list();
        listaAcessorios = new ListDataModel(lista);
        return listaAcessorios;
    }
     
     
    public String excluirAcessorio() {
       Acessorio acessorioTemp = (Acessorio) (listaAcessorios.getRowData());
        AcessorioDao dao = new AcessorioDao();
        dao.remove(acessorioTemp);
        return "listaAcessorios";
    }
    
    public String alterarAcessorio() {
        AcessorioDao dao = new AcessorioDao();
        dao.update(acessorio);
        return "listaAcessorios";
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    public DataModel getListaAcessorios() {
        return listaAcessorios;
    }

    public void setListaAcessorios(DataModel listaAcessorios) {
        this.listaAcessorios = listaAcessorios;
    }

    public List<Acessorio> getListaAcessoriosQuiosque() {
        List<Acessorio> lista = new AcessorioDao().list();
        return lista;
    }

    public void setListaAcessoriosQuiosque(List<Acessorio> listaAcessoriosQuiosque) {
        this.listaAcessoriosQuiosque = listaAcessoriosQuiosque;
    }
  
}
