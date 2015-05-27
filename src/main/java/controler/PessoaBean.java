package controler;

import dao.PessoaDao;
import java.io.Serializable;
import java.util.List;
import model.Endereco;
import model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class PessoaBean  implements Serializable {

    private Pessoa pessoa;
    private Endereco endereco;
    private DataModel listaPessoas;

    public PessoaBean () {
        endereco = new Endereco();
        pessoa = new Pessoa();
    }

    public String prepararAlterarPessoa() {
        pessoa = (Pessoa) (listaPessoas.getRowData());
        return "updatePessoa";
    }

    public String addPessoa() throws Exception {
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        dt = (Date) (java.util.Date) formatter.parse(data);
//        pessoa.setData_nasc(dt);
        PessoaDao pessoaDAO = new PessoaDao();
        pessoa.setEndereco(endereco);
        pessoaDAO.save(pessoa);
        return "listaPessoas";
    }

    public DataModel listarPessoas() {
        List<Pessoa> lista = new PessoaDao().list();
        listaPessoas = new ListDataModel(lista);
        return listaPessoas;
    }

    public String excluirPessoa() {
        Pessoa pessoaTemp = (Pessoa) (listaPessoas.getRowData());
        PessoaDao dao = new PessoaDao();
        dao.remove(pessoaTemp);
        return "listaPessoas";
    }

    public String alterarPessoa() {
        PessoaDao dao = new PessoaDao();
        dao.update(pessoa);
        return "listaPessoas";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public DataModel getListaPessoas() {
        return listaPessoas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setListaPessoas(DataModel listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
