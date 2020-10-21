//William Dunn - 245 - Extra Credit

package extracredit;

import java.util.List;
import java.util.Scanner;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;

public class jfacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String accessToken = "EAACEdEose0cBAJgWWOGrzZBmZAlWaYFj9r7U6LW3eSqsUZAiFKA0IEPXRyZCUqwFRXZAcjfDL9iZA0wPVjXV0wjBZC5qHC5NryUzZCgGihdd05SEwgw8gj4HEt8JRr4LhLf0XNnFZCWNZCQ0Pnes2ZAzARjVipF2ZBWIoXoCoECTceDNlPlcPHcdw1onkpehZB0PcXjMedgSw2h4ACAZDZD";

		FacebookClient fbClient = new DefaultFacebookClient(accessToken);

		String option;
		Scanner sc = new Scanner(System.in);

		System.out.println("How many pages have I 'liked' or how many posts are on my 'timeline'?");
		System.out.print(": ");
		option = sc.next();

		sc.close();

		int numResults = 0;

		switch (option) {
		case "liked":
			Connection<Page> result = fbClient.fetchConnection("me/likes", Page.class);

			for (List<Page> feedPage : result) {
				for (Page page : feedPage) {
					// System.out.println(page.getName());
					page.getName();
					numResults++;
				}
			}
			System.out.println("Total number of liked pages: " + numResults);
			break;
		case "timeline":
			Connection<Post> result1 = fbClient.fetchConnection("me/feed", Post.class);

			for (List<Post> page : result1) {
				for (Post aPost : page) {
					// System.out.println(aPost.getMessage());
					aPost.getMessage();
					numResults++;
				}
			}
			System.out.println("Total number of posts: " + numResults);
			break;
		default:
			System.err.println("invalid option");
			System.exit(-1);
		}
		System.exit(0);
	}
}
