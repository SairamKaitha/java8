package dateApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		
		Date d = new Date();
		System.out.println(d);
		
		//converting date to string
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String format =  sdf.format(d);
		System.out.println(format);
		
		//convert string to date
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		Date parsedDate = sdf1.parse("2025/03/20");
		System.out.println(parsedDate);
		
	    LocalDate date = LocalDate.now();
	    System.out.println(date);
	    
	     date =date.plusDays(5);
	     System.out.println(date);
	     
	     date = date.plusMonths(2);
	     System.out.println(date);
	     
	     boolean leapYear = LocalDate.parse("2020-06-25").isLeapYear();
	     System.out.println(leapYear);
		
        Period between =  Period.between(LocalDate.parse("1998/06/25"), LocalDate.now());
        System.out.println(between);
	}

}
