package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            System.out.println();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("++++++++++++ Menu ++++++++++++");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
        System.out.println("++++++++++++++++++++++++++++++");
    }


    public static void main(String[] args) {

        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(),
                new ShowAllAction(), new ReplaceAction(),
                new DeleteAction(), new FindByIdAction(),
                new FindByNameAction(), new Exit()};
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

