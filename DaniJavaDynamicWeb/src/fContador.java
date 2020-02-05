

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/fContador")
public class fContador implements Filter {
	FilterConfig fconfig;
	
    public fContador() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext miContexto = fconfig.getServletContext();

		Integer intContador = (Integer) miContexto.getAttribute("cont");
		if (intContador == null) {
			intContador = Integer.valueOf(0);
		}

		intContador = Integer.valueOf(intContador.intValue() + 1);
		miContexto.setAttribute("cont", intContador);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fconfig = fConfig;
	}

}
