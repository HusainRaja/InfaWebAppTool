package mdmUtil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import mdmUtil.model.MDMConnection;

@ComponentScan("mdmUtil")
@EnableWebMvc
@Configuration
public class SpringConfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("In the Spring config view resolver..");
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	@Bean
	public MDMConnection mdmConnection() {
		System.out.println("In the Spring config MDMconnection method ..");
		MDMConnection bean= new MDMConnection();
		bean.setEjbContext(true);
		bean.setInitcontextFactory("org.wildfly.naming.client.WildFlyInitialContextFactory");
		bean.setNamingFactory("org.jboss.ejb.client.interfaces");
		bean.setOrsId("pdb-MDM_SAMPLE");
		bean.setProviderURL("remote://localhost:4447");
		bean.setSiperianClientProtocol("ejb");
		return bean;
	}
	

}
