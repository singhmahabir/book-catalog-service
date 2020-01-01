package singh.mahabir.bcs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import singh.mahabir.bcs.sl.model.UserRatings;

/**
 * It is a Feign Client of ratings-data-service
 *
 * It represents as a ratings-data-service client to call it's end points
 *
 * @author Mahabir Singh
 *
 */
@FeignClient(value = "ratings-data-service", fallbackFactory = RatingsDataClientFallbackFactory.class)
// RequestMapping code will not work when we have fallback or fallbackFactory
//@RequestMapping(path = "/ratings/")
public interface RatingsDataClient {

    /**
     * getUserRating takes userId and returns {@link UserRatings} UserRatings class
     * which contains User rating details
     *
     * @param userId userId
     * @return UserRatings
     */
    @GetMapping(path = "/ratings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserRatings> getUserRating(@PathVariable String userId);

}
