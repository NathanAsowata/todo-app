package com.nathanasowata;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task tasks = new Task();


        System.out.println("Add a task: ");
        String firstTask = scanner.nextLine();
        tasks.addNewTask(firstTask);

        System.out.println("""
                Instructions:\s
                 add: adds a new task\
                \s
                 show: shows all tasks\
                \s
                 delete: deletes a task\
                \s
                 exit: to end the program""");

        System.out.println("Your call: ");
        String userInput = scanner.nextLine().toLowerCase();
        handlePrompt(userInput, scanner, tasks);
    }

    static void handlePrompt (String userInput, Scanner scanner, Task tasks) {

        switch (userInput) {
            case "add" -> {

                // Add task
                System.out.println("Task: ");
                userInput = scanner.nextLine();
                tasks.addNewTask(userInput);

                // Wait for next command
                System.out.println("Next prompt: ");
                userInput = scanner.nextLine();
                handlePrompt(userInput, scanner, tasks);
            }
            case "show" -> {

                // Show task
                tasks.showTasks();

                // Wait fot next command
                System.out.println("Next prompt: ");
                userInput = scanner.nextLine();
                handlePrompt(userInput, scanner, tasks);
            }
            case "delete" -> {

                // Show task for easier UX
                tasks.showTasks();

                // Delete task
                System.out.println("Type the task you want to delete: ");
                userInput = scanner.nextLine();
                tasks.deleteTask(userInput);

                // Wait for next command
                System.out.println("Next prompt: ");
                userInput = scanner.nextLine();
                handlePrompt(userInput, scanner, tasks);
            }
            case "help" -> {
                System.out.println("""
                        Instructions:\s
                         add: adds a new task\
                        \s
                         show: shows all tasks\
                        \s
                         delete: deletes a task\
                        \s
                         exit: to end the program""");
                handlePrompt(userInput, scanner, tasks);
            }

            case "exit" ->

                // End program
                    System.out.println("Program ending!");
            default -> {
                System.out.println("Invalid input");
                System.out.println("""
                        Instructions:\s
                         add: adds a new task\
                        \s
                         show: shows all tasks\
                        \s
                         delete: deletes a task\
                        \s
                         exit: to end the program""");
                handlePrompt(userInput, scanner, tasks);
            }
        }
    }
}