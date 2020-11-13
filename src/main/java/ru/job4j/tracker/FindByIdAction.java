package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        Item resultOfFind = tracker.findById(id);
        if (resultOfFind != null) {
            // вывод об успешности операции
            out.println("Item with Id=" + id + " was find in tracker");
            out.println(resultOfFind);
        } else {
            // вывод об ошибке
            out.println("Ой, всё! Заявка с id=" + id + " не найдена");
        }
        return true;
    }
}