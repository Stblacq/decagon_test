package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleUserResponsePojo {
	

	private Long page;
	private Integer per_page;
	private Integer total;
	private Integer total_pages;
	private List<User> data;

}
