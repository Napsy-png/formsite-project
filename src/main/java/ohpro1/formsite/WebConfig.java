package ohpro1.formsite;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("Post", "GET", "PUT", "DELETE");
	}

}
