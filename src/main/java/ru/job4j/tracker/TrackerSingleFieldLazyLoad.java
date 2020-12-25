package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFieldLazyLoad {
    private static Tracker instance;

    private TrackerSingleFieldLazyLoad() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleFieldLazyLoad.getInstance();
    }
}