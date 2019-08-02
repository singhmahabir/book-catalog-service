/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package singh.mahabir.bcs.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.bcs.sl.model.Book;

/**
 * 
 * While adding this class in @FeignClient fallback attributes Hystrix
 * internally uses this class when circuits breaks for default response
 * 
 * @author Mahabir Singh
 *
 */
@Component
@Slf4j
public class BookInfoClientFallback implements BookInfoClient {

	@Override
	public ResponseEntity<Book> getMoviesDetails(String bookId) {
		log.info("BookInfoClientFallback returning the default value");
		return ResponseEntity.ok(new Book(bookId, "", "", "", null));
	}

}
