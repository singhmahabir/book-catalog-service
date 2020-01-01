/**
 *
 */
package singh.mahabir.bcs.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * If you want to consume 'basic-authentication' protected Restful web service
 * via feign client
 *
 * <p>
 * If you don't use this @Configuration class on top of {@link FeignClient} then
 * this configuration is applied on each FeignClient call
 *
 * @author Mahabir Singh
 *
 */
@Configuration
public class FeignClientConfiguration {

    @Value("${client.common.username}")
    private String password;

    @Value("${client.common.password}")
    private String username;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
	return new BasicAuthRequestInterceptor(username, password);
    }
}
