package com.nathanasowata;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task {
    private Map<String, String> tasks =  new HashMap<>();
    private final Set<String> taskSet = this.tasks.keySet();

    public Map<String, String> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, String> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<String> allCompletedTasks(){
        ArrayList<String> completedTasks = new ArrayList<>();


        for(String task : this.taskSet){
            if(this.tasks.get(task).equals("completed")){
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public ArrayList<String> allPendingTasks(){
        ArrayList<String> pendingTasks = new ArrayList<>();

        for (String task : this.taskSet){
            if(this.tasks.get(task).equals("pending")){
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    public void showTasks(){
        System.out.println("Status \t \t Tasks");

        for(String task : this.taskSet){
            System.out.println(this.tasks.get(task) + "\t \t" + task);
        }
    }

    public void addNewTask(String task){
        this.tasks.put(task, "pending");
    }

    public void deleteTask(String task){
        this.tasks.remove(task);
    }
}
