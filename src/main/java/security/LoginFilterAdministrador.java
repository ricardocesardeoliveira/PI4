package security;

import exception.AcessoNegadoAdministrador;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilterAdministrador", urlPatterns = {"/administrador/*"})
public class LoginFilterAdministrador implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public LoginFilterAdministrador() {
    }    
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        
        if(session != null) {
            if ((session.getAttribute("userAdministrador") != null) && ((String) session.getAttribute("userAdministrador")).trim().length() > 0 )  {
                chain.doFilter(request, response);
            }else{
                throw new AcessoNegadoAdministrador();
            }
        }else{
            throw new AcessoNegadoAdministrador();
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("LoginFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
