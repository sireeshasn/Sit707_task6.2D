package sit707_tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeadlineReminderSystem {
	public static class Task {
		String taskId;
		LocalDate deadline;

		public Task(String taskId, LocalDate deadline) {
			this.taskId = taskId;
			this.deadline = deadline;
		}

		public String getTaskId() {
			return taskId;
		}

		public LocalDate getDeadline() {
			return deadline;
		}
	}

	public List<String> getUpcomingDeadlines(List<Task> tasks, LocalDate today) {
		List<String> upcoming = new ArrayList<>();
		for (Task task : tasks) {
			if (!task.getDeadline().isBefore(today) && task.getDeadline().isBefore(today.plusDays(4))) {
				upcoming.add(task.getTaskId() + " is due on " + task.getDeadline());
			}
		}
		return upcoming;
	}

	public List<String> getOverdueTasks(List<Task> tasks, LocalDate today) {
		List<String> overdue = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getDeadline().isBefore(today)) {
				overdue.add(task.getTaskId() + " was due on " + task.getDeadline());
			}
		}
		return overdue;
	}

	public long countTasksDueToday(List<Task> tasks, LocalDate today) {
		return tasks.stream().filter(task -> task.getDeadline().isEqual(today)).count();
	}

}
