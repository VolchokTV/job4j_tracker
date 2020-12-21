package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFieldLazyLoad {
    private static TrackerSingleFieldLazyLoad instance;

    private TrackerSingleFieldLazyLoad() {
    }

    public static TrackerSingleFieldLazyLoad getInstance() {
        if (instance == null) {
            instance = new TrackerSingleFieldLazyLoad();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}