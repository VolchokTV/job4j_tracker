package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {


    public static void main(String[] args) {

        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime currentDT = item.getCreated();
        String currentDateTimeFormat = currentDT.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        System.out.println(item);

        Item itemNoOne = new Item(1, "One");
        Tracker trackerNoOne = new Tracker();
        Item alarmItem = trackerNoOne.add(itemNoOne);
        System.out.println(trackerNoOne.findById(1));
        System.out.println(trackerNoOne.findById(10));

    }
}

