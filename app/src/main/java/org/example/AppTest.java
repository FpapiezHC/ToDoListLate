package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TaskManagerTest {
    @Test
    void shouldAddTask() {
        TaskList taskList = new TaskList();
        taskList.addTask("Buy milk");

        List<String> allTasks = taskList.getAllTasks();
        assertTrue(allTasks.contains("Buy milk"));
    }
    @Test
    void shouldMarkTaskAsComplete() {
        TaskList taskList = new TaskList();
        taskList.addTask("Buy eggs");
        taskList.markComplete("Buy eggs");

        List<String> completedTasks = taskList.getCompletedTasks();
        assertTrue(completedTasks.contains("Buy eggs"));
    }
    @Test
    void shouldClearAllTasks() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.removeAllTasks();

        List<String> allTasks = taskList.getAllTasks();
        assertTrue(allTasks.isEmpty());
    }
    @Test
    void shouldIdentifyIncompleteTasks() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task A");
        taskList.addTask("Task B");
        taskList.markComplete("Task A");
        List<String> pendingTasks = taskList.getPendingTasks();
        assertTrue(pendingTasks.contains("Task B"));
        assertFalse(pendingTasks.contains("Task A"));
    }
}
