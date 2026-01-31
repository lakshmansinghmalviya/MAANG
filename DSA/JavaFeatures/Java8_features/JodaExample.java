import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class JodaExample {
	public static void main(String[] args) throws InterruptedException {
//		1. Get current date and time
		LocalDate date = LocalDate.now();
		System.out.println(date + " Date");
		LocalTime time = LocalTime.now();
		System.out.println(time + " Time");
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Date and Time " + dateTime);
		String[] times = dateTime.toString().split("T");
		System.out.println("Date and Time " + times[0] + "   " + times[1]);

//		2. Minus 5 days and subtract 3 months from current date
		LocalDateTime ldt = LocalDateTime.now().minusDays(5);
		System.out.println("5 days before the month and day  was " + ldt.getMonth() + " " + ldt.getDayOfMonth());
		System.out.println(
				"5 days before the month and day  was " +ldt.getMonth().getValue() + " " + ldt.getDayOfMonth());

//		3. Find difference in two dates
		LocalDate sDate = LocalDate.of(2003, Month.JUNE, 10);
		LocalDate eDate = LocalDate.of(2025, Month.JUNE, 30);

		System.out.println("The date differ in year is is " + ChronoUnit.YEARS.between(sDate, eDate));
		System.out.println("The date differ in months is is " + ChronoUnit.MONTHS.between(sDate, eDate));
		System.out.println("The date differ in days is is " + ChronoUnit.DAYS.between(sDate, eDate));

//		4. Check if a given year is a leap year
		int year = 2024;
		boolean isLeapYear = Year.of(year).isLeap();
		System.out.println(year + " is leap year ? " + isLeapYear);

//		5. Find the age of you  at this time comparing dates
		LocalDate d1 = LocalDate.of(2003, Month.JUNE, 10);
		LocalDate d2 = LocalDate.now();
		Period p = Period.between(d1, d2);
		System.out.println("The age , month, day, difference b/w your BOD and now is " + "Year : " + p.getYears()
				+ ",  Month : " + p.getMonths() + ",  Days : " + p.getDays());

//   6. Format and parse a date string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate date2 = LocalDate.parse("29-06-2025", formatter);
		String formatted = date2.format(formatter);

		System.out.println("Parsed: " + date2);
		System.out.println("Formatted: " + formatted);

//	7. Find first and last day of the month 
		LocalDate dt = LocalDate.of(2025, Month.MAY, 23);
		LocalDate fDay = dt.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lDay = dt.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("First and last day of the month with complete date form " + fDay + "    " + lDay);
		System.out.println("First and last day of the month " + fDay.getDayOfMonth() + " - " + lDay.getDayOfMonth());
	
//	8. Measure time differs 
		Instant i = Instant.now();
		Thread.sleep(2000);
		Instant i2 = Instant.now();
		Duration d = Duration.between(i, i2);
		System.out.println("The duration is "+d.getSeconds());
	}
}
