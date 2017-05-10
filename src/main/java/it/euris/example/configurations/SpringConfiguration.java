package it.euris.example.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import it.euris.example.dao.UserDAO;
import it.euris.example.models.User;


/**Classe che istanzia i vari Beans. Si definisce un package in cui Spring deve scansionare per trovare le classi entità dalle quali creare i Bean qui definiti **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.euris.example")
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
		
	/**Questo BEAN si occupa di collegare il nome logico nel Controller ad una View esistente: NON DOBBIAMO INIETTARLO NOI**/
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/** INIZIO DEFINIZIONE DEI BEANS CHE CI INTERESSANO **/
	@Bean
	public User mioUtente(){
		return new User();
	}
	
	@Bean
	public User luciaUser(){
		return new User("Lucia", "Distante");
	}
	
	/*@Bean
	public UserDAO userDAO(){	//prova xke non c'era
		return new UserDAO();
	}*/
	
	
}
