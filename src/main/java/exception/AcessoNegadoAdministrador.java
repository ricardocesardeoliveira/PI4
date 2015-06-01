
package exception;


public class AcessoNegadoAdministrador extends RuntimeException {

    public AcessoNegadoAdministrador() {
    }

    public AcessoNegadoAdministrador(String msg) {
        super(msg);
    }
}
