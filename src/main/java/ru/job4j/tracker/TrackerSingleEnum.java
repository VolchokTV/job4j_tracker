package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public enum TrackerSingleEnum {
    INSTANCE;


    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
    }
}