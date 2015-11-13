package br.com.lorencity.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value="/*")
public class LoginFilter implements Filter {

    public LoginFilter() {   
    }   
  
    public void init(FilterConfig arg0) throws ServletException {   
    }   
  
    public void destroy() {   
    }   
  
    public void doFilter(ServletRequest request, ServletResponse response,   
            FilterChain chain) throws IOException, ServletException {  
    	
        HttpServletRequest hreq = (HttpServletRequest) request;   
        HttpServletResponse hresp = (HttpServletResponse) response;   
        HttpSession session = hreq.getSession();   
  
        String paginaAtual = new String(hreq.getRequestURL());   
  
        if (paginaAtual != null
        		&& (!paginaAtual.endsWith("Login.jsp")
        				&& (!paginaAtual.endsWith("ServletLogin")) 
        					&& (!paginaAtual.endsWith("ServletUsuario"))
        						&& (!paginaAtual.endsWith("ServletImagem"))
        							&& (!paginaAtual.endsWith("ServletBairros")) 
        								&& (!paginaAtual.endsWith("ServletProblemas")) 
				        					&&(!paginaAtual.endsWith(".css"))
				        						&&(!paginaAtual.endsWith(".png"))
				        							&& (paginaAtual.endsWith(".jsp")
				        									|| !paginaAtual.regionMatches((paginaAtual.length() - 5), ".", 0, 1)))) {   
		        					/** Adicionando � condi��o "se terminar com .jsp" um OR(OU) com 
		        					 *  a compara��o da substring ao final do endere�o "se n�o houver
		        					 *  ponto(.) no final", j� que nos servlets n�o h� extens�o no t�rmino
		        					 *  do endere�o, com isso o filtro n�o permitir� demais servlets.
		  							 */
            if (session.getAttribute("usuariologado") == null) {
            	hresp.sendRedirect("/SANIT/Login.jsp");
            	return;  
            }
        }
        // deliver request to next filter   
        chain.doFilter(request, response);   
    }   

}
