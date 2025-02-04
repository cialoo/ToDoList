package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task {
    Scanner scanner;
    private List<String> tasks = new ArrayList<>();

    Task(Scanner scanner) {
        this.scanner = scanner;
    }

    void getListOfTasks() {
        if(tasks.isEmpty()) {
            System.out.println("The list of tasks is empty!");
        } else {
            for(int i=0; i<tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    void addTask() {
        System.out.print("Type name of task: ");
        String taskToAdd = scanner.nextLine();
        tasks.add(taskToAdd);
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
}
