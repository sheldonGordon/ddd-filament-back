package fr.chatelain.filament.printer;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan("fr.chatelain.filament.core.entity.printer")
public class PrinterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrinterApplication.class, args);
	}

	@Bean
	public Hibernate5Module datatypeHibernateModule(){ return new Hibernate5Module(); }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
}
