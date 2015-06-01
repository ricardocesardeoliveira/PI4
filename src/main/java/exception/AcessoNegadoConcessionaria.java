
package exception;


public class AcessoNegadoConcessionaria extends RuntimeException {

    public AcessoNegadoConcessionaria() {
    }

    public AcessoNegadoConcessionaria(String msg) {
        super(msg);
    }
}
