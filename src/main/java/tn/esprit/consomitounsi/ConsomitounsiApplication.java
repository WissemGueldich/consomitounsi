package tn.esprit.consomitounsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration

public class ConsomitounsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsomitounsiApplication.class, args);
	}

}
