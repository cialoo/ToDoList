package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private Scanner scanner = new Scanner(System.in);
    private List<Task> tasks = new ArrayList<>();
    private boolean isRunning = true;

    public ToDoList() {
        System.out.println("Welcome to the to-do list!");
        while(isRunning) {
            menu();
        }
    }

    private void menu() {
        System.out.println("Choose what you want to do:");
        System.out.println("1. Show list of tasks.");
        System.out.println("2. Add task.");
        System.out.println("3. Complete task.");
        System.out.println("4. Delete task.");
        System.out.println("5. Close ToDoList.");

        try {
            int menuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    getListOfTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Choose from the list!");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must select the number that corresponds to the menu option!");
            scanner.nextLine();
        }
    }

    void getListOfTasks() {
        if(tasks.isEmpty()) {
            System.out.println("The list of tasks is empty!");
        } else {
            for(int i=0; i<tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i).toString() );
            }
        }
    }

    void addTask() {
        System.out.print("Type name of task: ");
        Task task = new Task(scanner.nextLine());
        tasks.add(task);
    }

    void removeTask() {
        System.out.print("Type task to delete: ");
        try {
            int taskToRemove = scanner.nextInt();
            tasks.remove(taskToRemove);
        }  catch (IndexOutOfBoundsException e) {
            System.out.println("The task number is not on the list!");
        } catch (InputMismatchException e) {
            System.out.println("You need to select a task number. The first task has the number 0!");
            scanner.nextLine();
        }
    }

    void completeTask() {
        System.out.print("Type task to complete: ");
        try {
            int taskToComplete = scanner.nextInt();
            tasks.get(taskToComplete).setDone(true);
        }  catch (IndexOutOfBoundsException e) {
            System.out.println("The task number is not on the list!");
        } catch (InputMismatchException e) {
            System.out.println("You need to select a task number. The first task has the number 0!");
            scanner.nextLine();
        }
    }
}
