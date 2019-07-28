# book-catalog-service

book-catalog-service depends on ratings-data-service and book-info-service

exposed the url below

localhost:9091//catalog/{userId}

book-catalog-service
	input -> userId
	output -> movie list with details
ratings-data-service (localhost:9093/ratings/{userId} )
	input -> userId
	output -> bookId's with rating and comment of users
book-info-service (localhost:9092/book/{bookId} )
	input -> bookId
	output -> book details for bookId
