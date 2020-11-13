package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idToEdit = input.askInt("Enter id for edit: ");
        String newName = input.askStr("Enter new name: ");
        Item newItem = new Item(newName);
        if (tracker.replace(idToEdit, newItem)) {
            // вывод об успешности операции
            out.println("Умею! Практикую!");
        } else {
            // вывод об ошибке
           out.println("Ой, всё!");
        }
        return true;
    }
}