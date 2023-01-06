package tn.esprit.ilyes_bettaieb_examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class IlyesBettaiebExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(IlyesBettaiebExamenApplication.class, args);
	}

}
