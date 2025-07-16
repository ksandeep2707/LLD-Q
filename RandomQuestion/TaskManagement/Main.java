package RandomQuestion.TaskManagement;
import java.util.Arrays;
import java.util.List;

import RandomQuestion.TaskManagement.Controller.TaskManagement;
import RandomQuestion.TaskManagement.Entity.Role;
import RandomQuestion.TaskManagement.Entity.Task;
import RandomQuestion.TaskManagement.Entity.TaskStatus;

public class Main{
    public static void main(String[] args) {
         TaskManagement system = new TaskManagement();


        String managerId=system.createUser("Alice", "alice@example.com",Role.MANAGER);
        System.out.println("Manager created successfully: "+managerId);
        String emp1Id=system.createUser("Bob", "bob@example.com",Role.EMPLOYEE);
        System.out.println("Emp1 created successfully: "+emp1Id);
        String emp2Id=system.createUser("Charlie", "charlie@example.com",Role.EMPLOYEE);
        System.out.println("Emp2 created successfully: "+emp2Id);

        
        String task1Id=system.createTask("TASK1", "task1 description", system.getUser(managerId));
        system.getTask(task1Id).assignToUsers(system.getUser(managerId),Arrays.asList(system.getUser(emp1Id),system.getUser(emp2Id)));
        String task2Id=system.createTask("TASK2", "task2 description", system.getUser(managerId));
        system.getTask(task2Id).assignToUser(system.getUser(managerId), system.getUser(emp1Id)); 
        

        // Check tasks for a specific user
        List<Task> tasksAssignedByUser = system.getTaskListAssignedByUser(system.getUser(managerId));
        System.out.println("Tasks assigned By Manager:");
        for (Task t : tasksAssignedByUser) {
            System.out.println(" " + t.getTitle() + " (" + t.getStatus() + ")");
        }

        //Update Status
        system.updateTaskStatus(task1Id, TaskStatus.IN_PROGRESS);
        system.showTaskDetails(task1Id);
        system.showTaskDetails(task2Id);
    }
}