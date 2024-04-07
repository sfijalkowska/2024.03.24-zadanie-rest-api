package pl.camp.it.zadanie.threads;

import pl.camp.it.zadanie.model.Item;

import java.util.Map;

public class AddItemThread implements Runnable {

    Map<String, Item> database;
    Item item;

    public AddItemThread(Map<String, Item> database, Item item) {
        this.database = database;
        this.item = item;
    }

    @Override
    public void run() {
        this.database.put(item.getIdGUID(), item);
    }
}
