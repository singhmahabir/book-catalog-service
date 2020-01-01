# book-catalog-service

*book-catalog-service depends on*
> - ratings-data-service
> - book-info-service

**Exposed urls below**

> localhost:9091/catalog/{userId}

**book-catalog-service**
> -	input -> userId
> -	output -> movie list with details

*ratings-data-service* (localhost:9093/ratings/{userId} )
> -	input -> userId
> -	output -> bookId's with rating and comment of users

**book-info-service** (localhost:9092/book/{bookId} )
> -	input -> bookId
> -	output -> book details for bookId

#### Hystrix Dashboard

1. http://localhost:9091/hystrix	
2. Hystrix Stream: http://localhost:9091/actuator/hystrix.stream

#### zipkin client

http://localhost:9091/customer/{cid}
