package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("++++++++++++ Menu ++++++++++++");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
        out.println("++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output),
                new ShowAllAction(output), new ReplaceAction(output),
                new DeleteAction(output), new FindByIdAction(output),
                new FindByNameAction(output), new Exit()};
        new StartUI(output).init(input, tracker, actions);

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