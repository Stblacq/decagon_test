package utils;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import pojos.ArticleUserResponsePojo;
import pojos.User;

import java.util.ArrayList;
import java.util.List;

import  static utils.Constants.*;


public class ApiCallsUtils {


	public static ArticleUserResponsePojo fetchArticleUser(String pageNumber) throws Exception {
		HttpResponse<String> jsonResponse
				= Unirest.get(GET_ARTICLE_USER_URL)
				.header("accept", "application/json").queryString("page", pageNumber)
				.asString();
		if (jsonResponse.getStatus() == 200) {
			Gson gson = new Gson();
			return gson.fromJson(jsonResponse.getBody(), ArticleUserResponsePojo.class);
		}
		return null;
	}

	public static List<User> getAllUsers() throws Exception {
		ArticleUserResponsePojo initial_response = fetchArticleUser("1");
		if (initial_response != null) {
			List<User> users = new ArrayList<User>(initial_response.getData());
			Integer page_number = initial_response.getTotal_pages();
			for (int i = 1; i < page_number; i++) {
				int current_page = i + 1;
				ArticleUserResponsePojo page_response = fetchArticleUser(String.valueOf(current_page));
				if (page_response != null) {
					users.addAll(page_response.getData());
				}
			}
			return users;
		}

		return null;

	}

}