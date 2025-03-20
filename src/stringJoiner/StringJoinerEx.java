package stringJoiner;

import java.util.StringJoiner;

public class StringJoinerEx {

	public static void main(String[] args) {
		StringJoiner j = new StringJoiner("-");
		j.add("sai");
		j.add("ram");
		j.add("dev");
		System.out.println(j);
		
		StringJoiner sj = new StringJoiner("-","(",")");
		
		sj.add("sairam");
		sj.add("java");
		sj.add("dev");
		System.out.println(sj);
	}

}
