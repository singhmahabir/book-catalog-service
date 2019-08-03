package singh.mahabir.bcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
 *                       But Either one of @EnableCircuitBreaker
 *                       or @EnableHystrix is required to see the hystrix status
 *                       in either Hystrix dashboard or Turbine dashboard
 *
 */
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class BookCatalogServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookCatalogServiceApplication.class, args);
	}

}
