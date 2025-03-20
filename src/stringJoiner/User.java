package stringJoiner;

import java.util.Optional;

public class User {

	public Optional<String> getUserName(Integer id) {
		 String name = null;
		 if(id==1)
			name="sai" ;
		 else if(id==2)
			 name="ram";
		 else if(id==3)
			 name="sairam";
		 return Optional.ofNullable(name);
	}
}
