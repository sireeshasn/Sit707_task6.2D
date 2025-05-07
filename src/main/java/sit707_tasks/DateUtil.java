package sit707_tasks;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Updated
 */
public class DateUtil {

	private LocalDate date;

	// Formatter for user-friendly output
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

	/*
	 * Constructs object from given day, month and year.
	 */
	public DateUtil(int day, int month, int year) {
		// Validate input and construct date
		if (day < 1 || month < 1 || month > 12 || year < 1700 || year > 2024) {
			throw new IllegalArgumentException("Invalid date components.");
		}
		try {
			this.date = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			throw new IllegalArgumentException("Invalid date: " + e.getMessage());
		}
	}

	/*
	 * Adds given number of days (can be negative) and returns a new DateUtil object.
	 */
	public DateUtil calculateFutureDate(int daysToAdd) {
		LocalDate newDate = this.date.plusDays(daysToAdd);
		return new DateUtil(newDate.getDayOfMonth(), newDate.getMonthValue(), newDate.getYear());
	}

	/*
	 * Getters
	 */
	public int getDay() {
		return date.getDayOfMonth();
	}

	public int getMonth() {
		return date.getMonthValue();
	}

	public int getYear() {
		return date.getYear();
	}

	/*
	 * User-friendly string output
	 */
	@Override
	public String toString() {
		return formatter.format(this.date);
	}
}
