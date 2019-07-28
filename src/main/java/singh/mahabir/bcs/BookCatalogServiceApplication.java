package singh.mahabir.bcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main class to start the book catalog service
 * 
 * @author Mahabir Singh
 *
 */
@SpringBootApplication
/**
 * The below annotation is required to make this application as client of eureka
 * but this annotation is not required when we added the eureka dependency
 */
@EnableDiscoveryClient
/**
 * @EnableFeignClients is used to call a end point id a micro services
 *
 */
@EnableFeignClients
//@EnableCircuitBreaker  // It is not required
public class BookCatalogServiceApplication {

	/**
	 * To call a end point one way to use RestTemplate
	 * 
	 * For that we need to create a bean and pass to SpringContaxt and we
	 * can @Autowired when required
	 * 
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookCatalogServiceApplication.class, args);
	}

}
