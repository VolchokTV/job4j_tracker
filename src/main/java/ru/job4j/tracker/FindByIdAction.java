package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}