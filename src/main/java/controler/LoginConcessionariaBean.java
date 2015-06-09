
package controler;

import dao.ConcessionariaDao;
import dao.PessoaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Concessionaria;
import model.Pessoa;

@ManagedBean
public class LoginConcessionariaBean {

    private Concessionaria concessionaria;
    
    public LoginConcessionariaBean() {
        concessionaria = new Concessionaria();
    }

    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

     public String efetuarLogin() {
        List<Concessionaria> lista = new ConcessionariaDao().list();
        String retorno = "loginConcessionaria";
        for (Concessionaria concessionaria : lista) {
            if( (this.concessionaria.getNome().equals(concessionaria.getNome()) && (this.concessionaria.getPassword().equals(concessionaria.getPassword())))) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("userConcessionaria", concessionaria.getNome());
                retorno = "indexConcessionaria";
            }
        }
        return retorno;
    }
     
     
     public void efetuarLogout() {
         FacesContext.getCurrentInstance().getExternalContext().getSession(false);
     }
}
