package ru.job4j.tracker;
import ru.job4j.tracker.Item;

public class TrackerSingleStaticFieldEager {
    private static final TrackerSingleStaticFieldEager INSTANCE = new TrackerSingleStaticFieldEager();

    private TrackerSingleStaticFieldEager() {
    }

    public static TrackerSingleStaticFieldEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFieldEager tracker = TrackerSingleStaticFieldEager.getInstance();
    }
}
