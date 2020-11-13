package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] resultOfFindByName = tracker.findByName(name);
        if (resultOfFindByName.length != 0) {
            // вывод об успешности операции
            out.println("Item(s) with Name=" + name + " was find in tracker");
            for (Item i : resultOfFindByName) {
                out.println(i);
            }
        } else {
            // вывод об ошибке
            System.out.println("Ой, всё! Заявка с именем=" + name + " не найдена");
        }
        return true;
    }
}
