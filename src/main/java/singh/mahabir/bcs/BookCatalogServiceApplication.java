package singh.mahabir.bcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
 * By having "spring-cloud-starter-netflix-eureka-client" on the classpath your
 * application will automatically register with the Eureka Server
 * without @EnableDiscoveryClient
 * 
 * since 1.4.7.RELEASE
 * 
 * Upto 1.3.6.RELEASE we required @EnableDiscoveryClient
 */
//@EnableDiscoveryClient
/**
 * @EnableFeignClients is used to call micro services end points
 * 
 *                     Feign is a declarative web service client
 * 
 * @EnableCircuitBreaker It is not required when using @EnableFeignClients
 *
 */
@EnableFeignClients
//@EnableCircuitBreaker
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
