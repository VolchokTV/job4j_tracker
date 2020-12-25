package ru.job4j.tracker;
import ru.job4j.tracker.Item;

public class TrackerSingleStaticFieldEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleStaticFieldEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleStaticFieldEager.getInstance();
    }
}
