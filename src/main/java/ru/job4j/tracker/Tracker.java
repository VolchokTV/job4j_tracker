package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] findAll = Arrays.copyOf(items, size);
        return  findAll;
    }

    public Item[] findByName(String key) {
        Item[] findByName = new Item[100];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            String name = items[i].getName();
            if (name.equals(key)){
                findByName[count] = items[i];
                count++;
            }
        }
        return findByName = Arrays.copyOf(findByName, count) ;
    }


    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

}