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

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean

	@Override
	protected UserDetailsService userDetailsService() {

		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("husain").password("husain").roles("ADMIN").build());

		return new InMemoryUserDetailsManager(users);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().and().authorizeRequests().antMatchers("/**").hasRole("ADMIN").and().logout().logoutUrl("/logout")  
        .logoutSuccessUrl("/")  .and().csrf().disable();
		
	}

}
