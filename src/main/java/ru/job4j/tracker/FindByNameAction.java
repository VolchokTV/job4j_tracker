package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
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
        return true;
    }
}
