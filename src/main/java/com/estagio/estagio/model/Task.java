package com.estagio.estagio.model;

public class Task {

    public Task(Long id, String name, String priority, boolean status) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public Task() {
    }

    private Long id;
    private String name;
    private String priority;
    private boolean status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
