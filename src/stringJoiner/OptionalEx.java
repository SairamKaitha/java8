package stringJoiner;

import java.util.Optional;
import java.util.Scanner;

public class OptionalEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a  number:");
		int userId=sc.nextInt();
		
		User user = new User();
		Optional<String> id = user.getUserName(userId);
		
		if(id.isPresent()) {
			String name = id.get();
			System.out.println(name.toUpperCase()+" "+" hello");
		}
		else {
			System.out.println("no user found");
		}
	}

}
