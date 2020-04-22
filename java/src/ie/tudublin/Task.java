package ie.tudublin;

import processing.data.TableRow;

public class Task {
    //attributes of the task object
    private String task;
    private int start;
    private int end;

    //constructors
    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }
    
    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"),tr.getInt("End"));
    }

    //Getters and setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    //toString method for printing task object
    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }

    
}