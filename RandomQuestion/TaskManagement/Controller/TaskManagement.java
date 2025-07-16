package RandomQuestion.TaskManagement.Controller;

import RandomQuestion.TaskManagement.Entity.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TaskManagement {
    Map<String, Task> tasks;
    Map<String, User> users;
    public final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    public TaskManagement()
    {
        this.tasks=new HashMap<>();
        this.users=new HashMap<>();
    }

    public String createUser(String name, String email, Role role) {
        User user = new Employee(name, email, role);
        users.put(user.getId(), user);
        return user.getId();
    }

    public String createTask(String title, String description, User createdBy) {
        Task task = new Task(title, description, createdBy);
        tasks.put(task.getId(), task);
        return task.getId();
    }

    public String updateTaskStatus(String taskId, TaskStatus status) {
       lock.writeLock().lock();
       try{
        System.out.println(Thread.currentThread().getName());
        if (!tasks.containsKey(taskId))
            return "Task does not exist";
        Task task = tasks.get(taskId);
        task.setStatus(status);
        return "Status Updated Successfully";
       }
       finally
       {
        lock.writeLock().unlock();
       }
    }

    public List<Task> getTaskListAssignedByUser(User assignedBy) {
        List<Task> taskAssignedBy = new ArrayList<>();
        for (Map.Entry<String, Task> task : tasks.entrySet()) {
            if (task.getValue().getAssignedBy().equals(assignedBy))
                taskAssignedBy.add(task.getValue());
        }
        return taskAssignedBy;
    }

    public void showTaskDetails(String taskId) {
        Task task = tasks.get(taskId);
        System.out.println("Task Title: " + task.getTitle());
        System.out.println("Task Desc: " + task.getDescription());
        System.out.println("Assigned By: " + task.getAssignedBy().getName());
        System.out.println("Task Status: " + task.getStatus());
        for(User assignee:task.getAssignee())
        {
            System.out.println("Assigned To: "+assignee.getName());
        }
    }

    public User getUser(String userId) {
        return this.users.get(userId);
    }

    public Task getTask(String taskId) {
        return this.tasks.get(taskId);
    }
}
