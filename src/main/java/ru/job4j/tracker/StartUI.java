package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                    System.out.println("=== Show all items ====");
                    Item[] allItems = tracker.findAll();
                    for (Item i: allItems) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter id for edit: ");
                int idToEdit = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                Item newItem = new Item(newName);
                if (tracker.replace(idToEdit, newItem)) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println( "Умею! Практикую!");
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё!");
                    System.out.println();
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter id for delete: ");
                int idToDelete = Integer.valueOf(scanner.nextLine());
                boolean resultDel =  tracker.delete(idToDelete);
                if (resultDel) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println( "Item with Id=" + idToDelete + " was delete from tracker");
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё! Заявка с таким id не найдена");
                    System.out.println();
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item resultOfFind =  tracker.findById(id);
                if (resultOfFind != null) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println( "Item with Id=" + id + " was find in tracker");
                    System.out.println(resultOfFind);
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё! Заявка с id=" + id +" не найдена");
                    System.out.println();
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] resultOfFindByName =  tracker.findByName(name);
                if (resultOfFindByName != null) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println( "Item(s) with Name=" + name + " was find in tracker");
                    for (Item i: resultOfFindByName) {
                        System.out.println(i);
                    }
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё! Заявка с именем=" + name + " не найдена");
                    System.out.println();
                }
            } else if (select == 6) {
                run = false;
            }
        }
        }


    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);


        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime currentDT = item.getCreated();
        String currentDateTimeFormat = currentDT.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        System.out.println(item);

        Item itemNoOne = new Item(1, "One");
        Tracker trackerNoOne = new Tracker();
        Item alarmItem = trackerNoOne.add(itemNoOne);
        System.out.println(trackerNoOne.findById(1));
        System.out.println(trackerNoOne.findById(10));

    }
}

