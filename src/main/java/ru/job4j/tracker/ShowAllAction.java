package ru.job4j.tracker;

public class ShowAllAction implements UserAction{

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (Item i : allItems) {
            System.out.println(i);}
        return true;
    }
}
