package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int idToDelete = input.askInt("Enter id for delete: ");
        boolean resultDel = tracker.delete(idToDelete);
        if(resultDel) {
            // вывод об успешности операции
            out.println("Item with Id=" + idToDelete + " was delete from tracker");
        }else{
            // вывод об ошибке
            out.println("Ой, всё! Заявка с таким id не найдена");
        }
        return true;
    }
}
