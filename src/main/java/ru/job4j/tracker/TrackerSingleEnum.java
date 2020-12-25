package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public enum TrackerSingleEnum {
    INSTANCE;
    private final Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleEnum.INSTANCE.getInstance();
    }
}