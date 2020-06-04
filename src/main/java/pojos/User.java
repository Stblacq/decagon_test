package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private Long id;
	private String username; 
	private String about;
	private Integer submitted;
    private Integer submission_count;
    private Integer comment_count;
    private Long created_at;
    private Date updated_at;

    public static Comparator<User> compareByCommentCount = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.comment_count.compareTo(u2.getComment_count());
        }
    };

    public static Comparator<User> compareByRecordDate = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.getCreated_at().compareTo(u2.getCreated_at());
        }
    };
}
