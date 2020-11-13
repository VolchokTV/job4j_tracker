package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
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

        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);

    //    Item item = new Item();
    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    //    LocalDateTime currentDT = item.getCreated();
    //    String currentDateTimeFormat = currentDT.format(formatter);
    //    System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    //    System.out.println(item);

    //    Item itemNoOne = new Item(1, "One");
    //    Tracker trackerNoOne = new Tracker();
    //    Item alarmItem = trackerNoOne.add(itemNoOne);
    //    System.out.println(trackerNoOne.findById(1));
    //    System.out.println(trackerNoOne.findById(10));
    }
}

