package ohpro1.formsite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ohpro1.formsite.domain.*;


@SpringBootApplication
public class FormsiteApplication {
	
	private static final Logger log = LoggerFactory.getLogger(FormsiteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FormsiteApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner LoadDatabase(QuestionRepository qrepo) {
		return args ->{
			log.info("Initializing");
			
			
			
			
			
		};
		
	}

}
