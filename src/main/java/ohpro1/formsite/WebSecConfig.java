package ohpro1.formsite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// set config to auth object
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("ohpro")
		.roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder getpasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/questions", "/answers", "/people").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.and().formLogin()
        .and().csrf().disable();
		http.cors();
	}
	
	

}
