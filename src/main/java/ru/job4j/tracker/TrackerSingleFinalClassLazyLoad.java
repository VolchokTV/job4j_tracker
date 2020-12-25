package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalClassLazyLoad {

    private TrackerSingleFinalClassLazyLoad() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleFinalClassLazyLoad.getInstance();

    }
}