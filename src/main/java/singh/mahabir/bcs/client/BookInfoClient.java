package singh.mahabir.bcs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import singh.mahabir.bcs.sl.model.Book;

/**
 * It is a Feign Client of book-info-service
 * 
 * It represents as a book-info-service client to call it's end points
 * 
 * @author Mahabir Singh
 *
 */
@FeignClient(value = "book-info-service", fallback = BookInfoClientFallback.class)
//@FeignClient(name="book-info-service",fallback= BookInfoClientFallback.class)
public interface BookInfoClient {

	/**
	 * A generic method which sends the response for any bookId
	 * 
	 * @param bookId bookId
	 * @return {@link Book}
	 */
	@GetMapping(path = "/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getMoviesDetails(@PathVariable String bookId);
	
}
