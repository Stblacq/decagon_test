package functions;

import pojos.User;

import java.util.ArrayList;
import java.util.List;

import static pojos.User.compareByCommentCount;
import static pojos.User.compareByRecordDate;
import static utils.ApiCallsUtils.getAllUsers;

public class ReadMe1Functions {

    public static List<String> getUsernames(int threshold) throws Exception{
        List<User> users = getAllUsers();
        List<String> activeUsernames = new ArrayList<>();
        if (users != null){
        for (User user: users) {
            int activity = user.getComment_count()+user.getSubmitted();
            if (activity>=threshold){
                activeUsernames.add(user.getUsername());
            }
        }
        }

        return activeUsernames;
    }

    public static String getUsernameWithHighestCommentCount()throws Exception{
        List<User> users = getAllUsers();
        assert users != null;
        users.sort(compareByCommentCount);
        return users.get(users.size()-1).getUsername();
    }

    public static List<String> getUsernamesSortedByRecordDate(int threshold) throws Exception{
        List<User> users = getAllUsers();
        assert users != null;
        users.sort(compareByRecordDate);
        List<String> usernames = new ArrayList<>();
        for (User user: users) {
           if (user.getCreated_at()>= (long) threshold){
               usernames.add(user.getUsername());
           }
        }

        return usernames;
        }

}
