package fr.chatelain.filament.filament;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilamentApplication.class, args);
	}

	@Bean
	public Hibernate5Module datatypeHibernateModule(){
		return new Hibernate5Module();
	}
}
