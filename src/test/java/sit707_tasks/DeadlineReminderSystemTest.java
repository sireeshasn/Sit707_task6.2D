package sit707_tasks;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class DeadlineReminderSystemTest {

	@Test
	public void testGetUpcomingDeadlinesWithin3Days() {
		DeadlineReminderSystem system = new DeadlineReminderSystem();
		LocalDate today = LocalDate.of(2025, 5, 20);
		List<DeadlineReminderSystem.Task> tasks = Arrays.asList(
				new DeadlineReminderSystem.Task("Task1", today.plusDays(1)),
				new DeadlineReminderSystem.Task("Task2", today.plusDays(3)),
				new DeadlineReminderSystem.Task("Task3", today.plusDays(5)));
		List<String> result = system.getUpcomingDeadlines(tasks, today);
		assertEquals(2, result.size());
	}

	@Test
	public void testNoUpcomingDeadlines() {
		DeadlineReminderSystem system = new DeadlineReminderSystem();
		LocalDate today = LocalDate.of(2025, 5, 20);
		List<DeadlineReminderSystem.Task> tasks = Arrays
				.asList(new DeadlineReminderSystem.Task("TaskA", today.plusDays(5)));
		List<String> result = system.getUpcomingDeadlines(tasks, today);
		assertTrue(result.isEmpty());
	}

	@Test
	public void testGetOverdueTasks() {
		DeadlineReminderSystem system = new DeadlineReminderSystem();
		LocalDate today = LocalDate.of(2025, 5, 20);
		List<DeadlineReminderSystem.Task> tasks = Arrays.asList(
				new DeadlineReminderSystem.Task("Task1", today.minusDays(1)),
				new DeadlineReminderSystem.Task("Task2", today.minusDays(3)),
				new DeadlineReminderSystem.Task("Task3", today.plusDays(2)));
		List<String> result = system.getOverdueTasks(tasks, today);
		assertEquals(2, result.size());
	}

	@Test
	public void testCountTasksDueToday() {
		DeadlineReminderSystem system = new DeadlineReminderSystem();
		LocalDate today = LocalDate.of(2025, 5, 20);
		List<DeadlineReminderSystem.Task> tasks = Arrays.asList(new DeadlineReminderSystem.Task("Task1", today),
				new DeadlineReminderSystem.Task("Task2", today),
				new DeadlineReminderSystem.Task("Task3", today.plusDays(1)));
		long count = system.countTasksDueToday(tasks, today);
		assertEquals(2, count);
	}

}
