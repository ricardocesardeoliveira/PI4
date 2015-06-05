package controler;

import dao.EnderecoDao;
import java.io.Serializable;
import model.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EnderecoBean  implements Serializable {

    private Endereco endereco;

    public String preparaAddEndereco() {
        endereco = new Endereco();
        return "addEndereco";
    }

    public String addEndereco() throws Exception {
        EnderecoDao marcaDAO = new EnderecoDao();
        marcaDAO.save(endereco);
        return "index";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
