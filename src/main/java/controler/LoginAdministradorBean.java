
package controler;

import dao.PessoaDao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import org.primefaces.context.RequestContext;

@ManagedBean
public class LoginAdministradorBean {

    private Pessoa pessoa;
    
    public LoginAdministradorBean() {
        pessoa = new Pessoa();
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public String efetuarLogin() {
        List<Pessoa> lista = new PessoaDao().list();
        String retorno = "loginAdministrador";
        for (Pessoa pessoa : lista) {
            if( (this.pessoa.getCpf().equals(pessoa.getCpf()) && (this.pessoa.getPassword().equals(pessoa.getPassword())))) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("userAdministrador", pessoa.getCpf());
                retorno = "indexAdministrador";
            }
        }
        return retorno;
    }
    
    public String efetuarLogout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "loginAdministrador";
    }


}
