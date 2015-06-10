
package controler;

import dao.AcessorioDao;
import dao.PessoaDao;
import dao.PrePedidoDao;
import dao.VeiculoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Acessorio;
import model.Concessionaria;
import model.Endereco;
import model.Kit;
import model.Marca;
import model.Pessoa;
import model.PrePedido;
import model.Veiculo;

@Named(value = "veiculoQuiosqueBean")
@SessionScoped
public class VeiculoQuiosqueBean implements Serializable {

    public VeiculoQuiosqueBean() {
        veiculo = new Veiculo();
        marca = new Marca();
        listaFiat = new ArrayList<>();
//        veiculoSelecionados = new ArrayList<>();
        listaAcessorios = new ArrayList<>();
//        listaAcessoriosSelecionados = new ArrayList<>();
        prePedido = new PrePedido();
        pessoa = new Pessoa();
        endereco = new Endereco();
    }

    private Veiculo veiculo;
    private Marca marca;
    private Veiculo veiculoSelecionado;
    private List<Veiculo> veiculoSelecionados;
    private List<Acessorio> listaAcessorios;
    private List<Acessorio> listaAcessoriosSelecionados;
    private List<Concessionaria> listaConcessionariasSelecionadas;
    private List<Veiculo> listaFiat;
    private PrePedido prePedido;
    private Pessoa pessoa;
    private Endereco endereco; 
    
    public String setarMarcaBMW(){
        this.marca.setNome("BMW");
        return "veiculos-bmw";
    }
    
    public String setarMarcaFiat(){
        this.marca.setNome("Fiat");
        return "veiculos-fiat";
    }
    
    public String setarMarcaNissan(){
        this.marca.setNome("Nissan");
        return "veiculos-nissan";
    }
    
    public String setarMarcaToyota(){
        this.marca.setNome("Toyota");
        return "veiculos-toyota";
    }
    
    public String setarMarcaVW(){
        this.marca.setNome("VolksWagen");
        return "veiculos-volkswagen";
    }
    
    
    public List<Veiculo> getVeiculosFiat() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosFiat();
        return lista;
    }
    
    public List<Veiculo> getVeiculosVW() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosVW();
        return lista;
    }
    
    public List<Veiculo> getVeiculosBMW() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosBMW();
        return lista;
    }
    
    public List<Veiculo> getVeiculosNissan() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosNissan();
        return lista;
    }
    
    public List<Veiculo> getVeiculosToyota() {
        List<Veiculo> lista = new VeiculoDao().listVeiculosToyota();
        return lista;
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }

    public List<Veiculo> getVeiculoSelecionados() {
        return veiculoSelecionados;
    }

    public void setVeiculoSelecionados(List<Veiculo> veiculoSelecionados) {
        this.veiculoSelecionados = veiculoSelecionados;
    }

    public List<Veiculo> getListaFiat() {
        return listaFiat;
    }

    public void setListaFiat(List<Veiculo> listaFiat) {
        this.listaFiat = listaFiat;
    }

    public String setarVeiculo(Long idVeiclulo){
        List<Veiculo> lista = new VeiculoDao().list();
        for (Veiculo veiculo : lista) {
            if (veiculo.getId_veiculo().equals(idVeiclulo)) {
                this.veiculo = veiculo;
            }
        }
        return "addAcessorioQuiosque";
    }
    
    public String adicionarAcessorios(){
        this.veiculo.setAcessorios(listaAcessoriosSelecionados);
        return "selecionarConcessionarias";
    }
    
    public String adicionarConcessionarias(){
//        this.prePedido.setConcessionaria1(listaConcessionariasSelecionadas.get(0));
        return "preencherCadastro";
    }

    public List<Acessorio> getListaAcessorios() {
        listaAcessorios = new AcessorioDao().list();
        return listaAcessorios;
    }

    public void setListaAcessorios(List<Acessorio> listaAcessorios) {
        this.listaAcessorios = listaAcessorios;
    }

    public List<Acessorio> getListaAcessoriosSelecionados() {
        return listaAcessoriosSelecionados;
    }

    public void setListaAcessoriosSelecionados(List<Acessorio> listaAcessoriosSelecionados) {
        this.listaAcessoriosSelecionados = listaAcessoriosSelecionados;
    }

    public List<Concessionaria> getListaConcessionariasSelecionadas() {
        return listaConcessionariasSelecionadas;
    }

    public void setListaConcessionariasSelecionadas(List<Concessionaria> listaConcessionariasSelecionadas) {
        this.listaConcessionariasSelecionadas = listaConcessionariasSelecionadas;
    }
    
    public String gerarPrepedido() {
        
        PessoaDao pessoaDAO = new PessoaDao();
//        pessoa.setEndereco(endereco);
        pessoaDAO.save(pessoa);
        
        double total = 0;
        for (Acessorio acessorio : listaAcessoriosSelecionados) {
            total += acessorio.getValor().doubleValue();
        }
        
        this.prePedido.setDia(new Date());
        this.prePedido.setVeiculo(this.veiculo);
        this.prePedido.setPessoa(this.pessoa);
        this.prePedido.setStatus("Aberto");
        this.prePedido.setPreco( (this.veiculo.getPreco().add(BigDecimal.valueOf(total))) );
        
        if (this.listaConcessionariasSelecionadas.get(0) != null) {
            this.prePedido.setConcessionaria1(this.listaConcessionariasSelecionadas.get(0));
        }
        if (this.listaConcessionariasSelecionadas.get(1) != null) {
            this.prePedido.setConcessionaria2(this.listaConcessionariasSelecionadas.get(1));
        }
        if (this.listaConcessionariasSelecionadas.get(2) != null) {
            this.prePedido.setConcessionaria3(this.listaConcessionariasSelecionadas.get(2));
        }

        PrePedidoDao prePedidoDao = new PrePedidoDao();
        prePedidoDao.save(this.prePedido);
        this.prePedido = new PrePedido();
        this.listaAcessoriosSelecionados = new ArrayList<>();
        this.listaConcessionariasSelecionadas = new ArrayList<>();
        
        return "indexQuiosque";
    } 

    public PrePedido getPrePedido() {
        return prePedido;
    }

    public void setPrePedido(PrePedido prePedido) {
        this.prePedido = prePedido;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
