package CalendarPrograms;
import java.util.Date;
import java.text.SimpleDateFormat;
public class getFromCalendar 
{

public static void main(String[] args) 
{
	//Not of use : Hence these are not preferred
	int day = new Date().getDay();
	System.out.println(day);
	int date = new Date().getDate();
	System.out.println(date);
	int month = new Date().getMonth();
	System.out.println(month);
	int hours = new Date().getHours();
	System.out.println(hours);
	int minutes = new Date().getMinutes();
	System.out.println(minutes);
	long time = new Date().getTime();
	System.out.println(time);
	int year = new Date().getYear();
	System.out.println(year);
}
}
