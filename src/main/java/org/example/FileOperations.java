package org.example;

import java.io.*;

import static org.example.ToDoList.tasks;

public class FileOperations {

    static String path = "todolist_data.txt";

    static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                boolean isDone = Boolean.parseBoolean(parts[1]);
                Task task = new Task(name);
                task.setDone(isDone);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong with reading the file.");
        }
    }

    static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Task task : tasks) {
                writer.write(task.getName() + ";" + task.isDone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong with saving the file.");
        }
    }

}
