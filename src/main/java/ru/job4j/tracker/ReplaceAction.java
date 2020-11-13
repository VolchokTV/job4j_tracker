package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}