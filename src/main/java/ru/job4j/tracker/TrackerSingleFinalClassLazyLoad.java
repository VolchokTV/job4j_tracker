package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public class TrackerSingleFinalClassLazyLoad {
    private TrackerSingleFinalClassLazyLoad() {
    }

    public static TrackerSingleFinalClassLazyLoad getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleFinalClassLazyLoad INSTANCE = new TrackerSingleFinalClassLazyLoad();
    }

    public static void main(String[] args) {
        TrackerSingleFinalClassLazyLoad tracker = TrackerSingleFinalClassLazyLoad.getInstance();
    }
}