
package model;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VeiculoAcessorio implements Serializable {
    
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    @ManyToOne
    private Veiculo veiculo;
    @JoinColumn(name = "id_acessorio)", referencedColumnName = "id_acessorio")
    @ManyToOne
    private Acessorio acessorio;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
    
}
