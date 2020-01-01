/**
 *
 */
package singh.mahabir.bcs.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mahabir Singh
 *
 */

@RestController
public class CustomerServie {

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }

    @Autowired
    RestTemplate webTemplate;

    @GetMapping(value = "/customer/{cid}")
    public @ResponseBody String getCustomer(@PathVariable Integer cid) {

	final ResponseEntity<String> contact = webTemplate
		.getForEntity("http://localhost:9092/customer/" + cid + "/contactdetails", String.class);
	final ResponseEntity<String> vehicle = webTemplate
		.getForEntity("http://localhost:9093/customer/" + cid + "/vehicledetails", String.class);

	return contact.getBody() + " | " + vehicle.getBody();

    }
}
