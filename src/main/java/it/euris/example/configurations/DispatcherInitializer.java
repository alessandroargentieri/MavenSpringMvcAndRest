package it.euris.example.configurations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**Classe che si occupa di inizializzare la Dispatcher Servlet di Spring senza dover usare il Deployment Descriptor**/

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	/** Override dell'interfaccia WebApplicationInitializer usata per Spring web mvc **/
	
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	
	
	/** Override dei metodi di AbstractAnnotationConfigDispatcherServlet per i servizi REST **/
	
	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { SpringConfiguration.class };
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}