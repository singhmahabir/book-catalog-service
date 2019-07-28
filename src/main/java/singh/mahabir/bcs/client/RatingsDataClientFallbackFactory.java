/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.bcs.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import singh.mahabir.bcs.sl.model.UserRating;
import singh.mahabir.bcs.sl.model.UserRatings;

/**
 * Use FallbackFactory<T> interface to print the feign client exception
 * 
 * @author Mahabir Singh
 *
 */
@Component
@Slf4j
public class RatingsDataClientFallbackFactory implements FallbackFactory<RatingsDataClient> {

	@Override
	public RatingsDataClient create(Throwable cause) {
		log.info("request failed due to ex {}", cause);
		/**
		 * return new RatingsDataClient() {
		 * 
		 * @Override public ResponseEntity<UserRatings> getUserRating(String userId) {
		 *           UserRatings ratings = new UserRatings();
		 *           ratings.getRating().add(new UserRating("", 0, ""));
		 *           ratings.getRating().add(new UserRating("", 0, "")); return
		 *           ResponseEntity.ok(ratings); } };
		 */
		return s -> {
			UserRatings ratings = new UserRatings();
			ratings.getRating().add(new UserRating("", 0, ""));
			ratings.getRating().add(new UserRating("", 0, ""));
			return ResponseEntity.ok(ratings);
		};
	}
}
