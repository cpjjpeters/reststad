package be.ipeters.stad;

import be.ipeters.stad.entities.Stad;
import be.ipeters.stad.repositories.StadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StadApplication {

	public static void main(String[] args) {
		SpringApplication.run(StadApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}


	@Autowired
	StadRepository stadRepository;
	@Bean
	CommandLineRunner runner() {

		return args -> {
			Stad stad1 = new Stad("Antwerpen", 529247);
			Stad stad2 = new Stad("Brugge", 118656);
			Stad stad3 = new Stad("Luik", 197217);
			stadRepository.save(stad1);
			stadRepository.save(stad2);
			stadRepository.save(stad3);


		};
	}
}

