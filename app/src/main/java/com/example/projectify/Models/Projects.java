package com.example.projectify.Models;

public class Projects {
    //This class contains the projects
    private String project, task;
    private Boolean expandable;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }

    public Projects(String project, String task) {
        this.project = project;
        this.task = task;
        this.expandable = false;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "project='" + project + '\'' +
                ", event='" + task + '\'' +
                '}';
    }

    public boolean isExpandable(){
        // This method governs the ability to expand the tasks in user profile
        return expandable;
    }
}
