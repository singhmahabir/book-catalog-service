package singh.mahabir.bcs.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.bcs.client.BookInfoClient;
import singh.mahabir.bcs.client.RatingsDataClient;
import singh.mahabir.bcs.sl.model.Book;
import singh.mahabir.bcs.sl.model.UserRatings;

@Service
@Slf4j
public class BookCatalogService implements IBookCatalogService {

	/*
	 * When we call the dependent of micro service or external end point
	 * 
	 * So 1st way to use this
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	/*
	 * Use the below code when to use feign client
	 */
	@Autowired
	private BookInfoClient bookInfoClient;
	
	@Autowired
	private RatingsDataClient ratingsDataClient;
		
	
	
	@Override
	public UserRatings getUserRatingDetails(String userId){
		log.info("request came at service layer for userId {}", userId);
		
	/**	  // this way we can call rest Endpoints which returns List of Objects return
	 
		  restTemplate.exchange("http://localhost:9093/ratingsdata/users/"+userId,
		  HttpMethod.GET, null, new
		  ParameterizedTypeReference<List<Rating>>(){}).getBody();
		  */
		
		// return restTemplate.getForObject("http://localhost:9093/ratings/+"+userId,
		// UserRatings.class);
		return	ratingsDataClient.getUserRating(userId).getBody();
		
		 
	}

	@Override
	public Book getBookInformation(String bookId) {
		log.info("request came at service layer for bookId {}", bookId);
		// If we are using restTemplate as http client
		// return
		// restTemplate.getForObject("http://localhost:9092/book/"+bookId,Book.class);
		return bookInfoClient.getMoviesDetails(bookId).getBody();
	}
}
