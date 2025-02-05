package org.example;

public class Task {
    private String name;
    private boolean isDone = false;

    Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return name + " [" + (isDone() ? "x" : " ") + "]";
    }
}
