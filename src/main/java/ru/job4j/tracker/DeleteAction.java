package ru.job4j.tracker;

public class DeleteAction implements UserAction{

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
