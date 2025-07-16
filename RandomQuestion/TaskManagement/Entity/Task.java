package RandomQuestion.TaskManagement.Entity;
import java.util.*;

public class Task {
    private String id;
    private String title;
    private String description;
    private User assignedBy;
    private Map<String, User> assignees;
    private TaskStatus status;

    public Task(String title, String description, User createdBy) {
        this.title = title;
        this.description = description;
        this.assignedBy = createdBy;
        this.status = TaskStatus.TODO;
        this.id = UUID.randomUUID().toString();
        this.assignees=new HashMap<>();
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public User getAssignedBy() {
        return this.assignedBy;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public String getId()
    {
        return this.id;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    public void assignToUsers(User assignedBy, List<User> users) {
        for (User user : users) {
            String user_id = user.getId();
            if (!assignees.containsKey(user_id)) {
                assignees.put(user_id, user);
                setAssignedBy(assignedBy);
            }
        }
    }

    public void assignToUser(User assignedBy, User assignedTo) {
        if (!assignees.containsKey(assignedTo.getId())) {
            this.assignees.put(assignedTo.getId(), assignedTo);
            this.assignedBy = assignedBy;
        }
    }

    public List<User> getAssignee()
    {
       return  new ArrayList<>(this.assignees.values());
    }

}
