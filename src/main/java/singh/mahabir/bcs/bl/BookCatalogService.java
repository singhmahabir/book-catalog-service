package singh.mahabir.bcs.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import singh.mahabir.bcs.client.BookInfoClient;
import singh.mahabir.bcs.client.RatingsDataClient;
import singh.mahabir.bcs.sl.model.Book;
import singh.mahabir.bcs.sl.model.UserRatings;

/**
 * Service Layer implementation
 * 
 * @author Mahabir Singh
 *
 */
@Service
@Slf4j
public class BookCatalogService implements IBookCatalogService {

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
		return ratingsDataClient.getUserRating(userId).getBody();
	}

	@Override
	public Book getBookInformation(String bookId) {
		log.info("request came at service layer for bookId {}", bookId);
		return bookInfoClient.getMoviesDetails(bookId).getBody();
	}
}
