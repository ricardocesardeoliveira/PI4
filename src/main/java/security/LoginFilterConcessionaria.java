package security;

import exception.AcessoNegadoAdministrador;
import exception.AcessoNegadoConcessionaria;
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

@WebFilter(filterName = "LoginFilterConcessionaria", urlPatterns = {"/concessionaria/*"})
public class LoginFilterConcessionaria implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public LoginFilterConcessionaria() {
    }    
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
       
        HttpSession session = ((HttpServletRequest)request).getSession();
        
        if(session != null) {
            if ((session.getAttribute("userConcessionaria") != null) && ((String) session.getAttribute("userConcessionaria")).trim().length() > 0 )  {
                chain.doFilter(request, response);
            }else{
                throw new AcessoNegadoConcessionaria();
            }
        }else{
            throw new AcessoNegadoConcessionaria();
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
