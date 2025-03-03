package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.addTask("Buy milk");
        taskList.addTask("Buy eggs");
        taskList.addTask("Buy Water");
        taskList.addTask("Sow beet seeds");
        taskList.markComplete("Buy eggs");
        System.out.println("All Tasks:");
        taskList.displayAllTasks();
        System.out.println("Completed Tasks:");
        taskList.displayCompletedTasks();
        System.out.println("Pending Tasks:");
        taskList.displayPendingTasks();
        taskList.removeAllTasks();
        System.out.println("After clearing the list:");
        taskList.displayAllTasks();
    }
}

class TaskList {
    private final Map<String, Boolean> tasks = new LinkedHashMap<>();
    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            System.out.println("Cannot add an empty task!");
            return;
        }
        if (tasks.containsKey(task)) {
            System.out.println("This task already exists!");
            return;
        }
        tasks.put(task, false);
    }
    public void markComplete(String task) {
        if (tasks.containsKey(task)) {
            tasks.put(task, true);
        } else {
            System.out.println("Task not found!");
        }
    }
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            tasks.forEach((task, isDone) -> System.out.println(task + " - " + (isDone ? "Done" : "Pending")));
        }
    }
    public void displayCompletedTasks() {
        tasks.forEach((task, isDone) -> {
            if (isDone) {
                System.out.println(task);
            }
        });
    }
    public void displayPendingTasks() {
        tasks.forEach((task, isDone) -> {
            if (!isDone) {
                System.out.println(task);
            }
        });
    }
    public void removeAllTasks() {
        tasks.clear();
        System.out.println("All tasks have been cleared.");
    }
    public List<String> getAllTasks() {
        return new ArrayList<>(tasks.keySet());
    }
    public List<String> getCompletedTasks() {
        List<String> completed = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : tasks.entrySet()) {
            if (entry.getValue()) {
                completed.add(entry.getKey());
            }
        }
        return completed;
    }
    public List<String> getPendingTasks() {
        List<String> pending = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : tasks.entrySet()) {
            if (!entry.getValue()) {
                pending.add(entry.getKey());
            }
        }
        return pending;
    }
}
