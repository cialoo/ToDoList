package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoList {
    private Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;
    Task task = new Task(scanner);

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
        System.out.println("3. Delete task.");
        System.out.println("4. Close ToDoList.");

        try {
            int menuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    task.getListOfTasks();
                    break;
                case 2:
                    task.addTask();
                    break;
                case 3:
                    task.removeTask();
                    break;
                case 4:
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
}
