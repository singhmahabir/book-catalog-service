/**
 * Copyright 2019. All rights reserved.
 */

package singh.mahabir.bcs.sl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequst {

	private String userId;
	private String bookId;
	private Integer rating;
	private String comment;
}
