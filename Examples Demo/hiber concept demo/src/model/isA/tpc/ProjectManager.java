package model.isA.tpc;

public class ProjectManager extends User {
    private String creatingProject;

    public ProjectManager() {
    }

    public ProjectManager(String userName, String userEmail, String creatingProject) {
        super(userName, userEmail);
        this.creatingProject = creatingProject;
    }

    public ProjectManager(int userId, String userName, String userEmail, String creatingProject) {
        super(userId, userName, userEmail);
        this.creatingProject = creatingProject;
    }

    public String getCreatingProject() {
        return creatingProject;
    }

    public void setCreatingProject(String creatingProject) {
        this.creatingProject = creatingProject;
    }
}
