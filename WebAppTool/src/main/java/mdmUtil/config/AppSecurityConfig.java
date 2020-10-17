package mdmUtil.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import mdmUtil.service.MDMService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MDMService mdmService;
	
	
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(mdmService);
		
	}





	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/myLogin").permitAll().loginProcessingUrl("/appLogin").defaultSuccessUrl("/home").and().csrf().disable();
	}
	
	
	





	/*
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("husain").password(
	 * "husain").roles("ADMIN").build());
	 * 
	 * return new InMemoryUserDetailsManager(users);
	 * 
	 * }
	 */
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * System.out.println("In the configure method of AppSecurityConfig");
	 * http.authorizeRequests(). antMatchers("/**").hasRole("USER").
	 * and().formLogin(). //login configuration loginPage("/myLogin"). permitAll().
	 * loginProcessingUrl("/appLogin"). usernameParameter("userName").
	 * passwordParameter("userPassword"). defaultSuccessUrl("/home").
	 * and().logout(). //logout configuration logoutUrl("/appLogout").
	 * logoutSuccessUrl("/customLogin.jsp").and().csrf().disable();;
	 * 
	 * }
	 */

}
