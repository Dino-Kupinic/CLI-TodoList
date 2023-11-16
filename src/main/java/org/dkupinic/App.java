package org.dkupinic;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<TodoList> todoLists = new ArrayList<>();
        String operation = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Todo-List Manager");
        showInformation();

        while (!operation.equals("exit")) {
            System.out.print("--> ");
            operation = scanner.next();
            if (scanner.hasNextLine()) {
                switch (operation) {
                    case "n" -> todoLists.add(createTodo());
                    case "d" -> delete(todoLists);
                    case "h" -> showInformation();
                    case "exit" -> System.out.println("Exiting program");
                    case "p" -> printTodos(todoLists);
                    default -> System.out.println("Invalid Information");
                }
            }
            System.out.println("   [h] - show help information");
        }
    }

    public static void showInformation() {
        System.out.println("Enter: \n   [n] - new Todo-List \n" +
                "   [d] - delete exisiting Todo-List \n" +
                "   [exit] - exit program \n" +
                "   [p] - print all Todo-Lists with Todos"
        );
    }

    public static TodoList createTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Todo");
        System.out.print("Enter a Name for your Todo-List: ");

        return new TodoList(new ArrayList<>(), scanner.nextLine());
    }

    public static void delete(ArrayList<TodoList> todoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: \n   [t] - delete an element of a Todo-List \n" +
                "   [w] - delete whole Todo-List");
        System.out.println("--> ");

        switch (scanner.nextLine()) {
            case "t" -> deleteTodo();
            case "w" -> deleteTodoList(todoList);
            default -> System.out.println("Invalid Information");
        }
    }

    public static void deleteTodoList(ArrayList<TodoList> todoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Todo-List you would like to delete: ");
        String listName = scanner.nextLine();
        todoList.removeIf(t -> t.getName().equalsIgnoreCase(listName));
    }

    public static void deleteTodo() {
    }

    public static void printTodos(ArrayList<TodoList> todoList) {
        for (TodoList t : todoList) {
            System.out.println("Todo-List '" + t.getName() + "'");
            for (Todo element : t.getTodos()) {
                System.out.println("Todo: " + element.getTitle() + "'");
            }
        }
    }
}


