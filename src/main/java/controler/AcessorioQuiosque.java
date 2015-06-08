package controler;

import dao.AcessorioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Acessorio;
import org.primefaces.event.DragDropEvent;

@Named(value = "acessorioQuiosque")
@SessionScoped
public class AcessorioQuiosque implements Serializable {

    private List<Acessorio> acessorios;
    private List<Acessorio> acessoriosDropados;
    private Acessorio acessorioSelecionado;
     
    @PostConstruct
    public void init() {
        acessoriosDropados = new ArrayList<Acessorio>();
        acessorios = new AcessorioDao().list();
    }
     
    public void onCarDrop(DragDropEvent ddEvent) {
        Acessorio acessorio = ((Acessorio) ddEvent.getData());
        acessoriosDropados.add(acessorio);
        acessorios.remove(acessorio);
    }
     
    public List<Acessorio> getAcessorios() {
        return acessorios;
    }
 
    public List<Acessorio> getAcessoriosDropados() {
        return acessoriosDropados;
    }    
 
    public Acessorio getAcessorioSelecionado() {
        return acessorioSelecionado;
    }
 
    public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
        this.acessorioSelecionado = acessorioSelecionado;
    }
    
}
