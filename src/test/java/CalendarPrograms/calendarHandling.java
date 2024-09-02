package CalendarPrograms;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class calendarHandling 
{
	public static void main(String[] args) 
	{
		//To get the complete date information
		Date dateobj = new Date();
		System.out.println("System details for Date==> "+dateobj);
		
		//To retrieve the month
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String DateExtracted = sim.format(dateobj);
		System.out.println("Extracted date from system details==> "+DateExtracted);
		
		//********************************
		//To create a date as per requirement
		
		LocalDate ld = LocalDate.of(2024, 4, 5);//year,month,dayOfMonth
		System.out.println("Local Date ==>"+ld);//returns the date per input
		//To get the year from the date specified
		int year = ld.getYear();
		System.out.println("Year of the date given==>"+year);
		
		DayOfWeek dayOfWeek = ld.getDayOfWeek();
		System.out.println("Day of week==>"+dayOfWeek);
				
		
	}
}
