package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        for (Item i : allItems) {
            System.out.println(i);
        }
    }

    public static void deleteItem (Input input, Tracker tracker) {
         System.out.println("=== Delete Item ====");
         System.out.println();
         int idToDelete = Integer.valueOf(input.askStr("Enter id for delete: "));
         boolean resultDel = tracker.delete(idToDelete);
         if (resultDel) {
         // вывод об успешности операции
         System.out.println();
         System.out.println("Item with Id=" + idToDelete + " was delete from tracker");
         System.out.println();
         } else {
         // вывод об ошибке
         System.out.println();
         System.out.println("Ой, всё! Заявка с таким id не найдена");
         System.out.println();
         }
    }

    public static void replaceItem (Input input, Tracker tracker){
                System.out.println("=== Edit Item ====");
                System.out.println();
                int idToEdit = Integer.valueOf(input.askStr("Enter id for edit: "));
                System.out.println();
                String newName = input.askStr("Enter new name: ");
                Item newItem = new Item(newName);
                if (tracker.replace(idToEdit, newItem)) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println("Умею! Практикую!");
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё!");
                    System.out.println();
                }
    }

    public static void findItemById (Input input, Tracker tracker){
                System.out.println("=== Find item by Id ====");
                System.out.println();
                int id = Integer.valueOf(input.askStr("Enter Id: "));
                Item resultOfFind = tracker.findById(id);
                if (resultOfFind != null) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println("Item with Id=" + id + " was find in tracker");
                    System.out.println(resultOfFind);
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё! Заявка с id=" + id + " не найдена");
                    System.out.println();
                }
            }

    public static void findItemByName (Input input, Tracker tracker){
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Enter name: ");
                Item[] resultOfFindByName = tracker.findByName(name);
                if (resultOfFindByName.length != 0) {
                    // вывод об успешности операции
                    System.out.println();
                    System.out.println("Item(s) with Name=" + name + " was find in tracker");
                    for (Item i : resultOfFindByName) {
                        System.out.println(i);
                    }
                    System.out.println();
                } else {
                    // вывод об ошибке
                    System.out.println();
                    System.out.println("Ой, всё! Заявка с именем=" + name + " не найдена");
                    System.out.println();
                }
            }

    public void init (Input input, Tracker tracker){
          boolean run = true;
          while (run) {
          this.showMenu();
          System.out.println();
          int select = input.askInt("Select: ");
                    if (select == 0) {
                        StartUI.createItem(input, tracker);
                    } else if (select == 1) {
                        StartUI.showAllItems(input, tracker);
                    } else if (select == 2) {
                        StartUI.replaceItem(input, tracker);
                    } else if (select == 3) {
                        StartUI.deleteItem(input, tracker);
                    } else if (select == 4) {
                        StartUI.findItemById(input, tracker);
                    } else if (select == 5) {
                        StartUI.findItemByName(input, tracker);
                    } else if (select == 6) {
                        run = false;
                    }
                }
    }


    private void showMenu () {
                System.out.println("Menu.");
                System.out.println("0. Add new Item");
                System.out.println("1. Show all items");
                System.out.println("2. Edit item");
                System.out.println("3. Delete item");
                System.out.println("4. Find item by Id");
                System.out.println("5. Find items by name");
                System.out.println("6. Exit Program");

    }

    public static void main (String[]args){

                Input input = new ConsoleInput();
                Tracker tracker = new Tracker();
                new StartUI().init(input, tracker);

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

