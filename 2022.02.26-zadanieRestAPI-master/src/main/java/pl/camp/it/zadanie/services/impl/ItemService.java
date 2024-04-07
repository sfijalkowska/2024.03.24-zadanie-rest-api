package pl.camp.it.zadanie.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.zadanie.model.Item;
import pl.camp.it.zadanie.services.IItemService;
import pl.camp.it.zadanie.threads.AddItemThread;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Service
public class ItemService implements IItemService {

    @Autowired
    Map<String, Item> database;

    @Autowired
    ExecutorService executorService;

    @Override
    public void addItem(Item item) {
        executorService.submit(new AddItemThread(this.database, item));
        /*Thread thread = new Thread(new AddItemThread(this.database, item));
        thread.start();*/
    }

    @Override
    public Optional<Item> getItem(String idGUID) {
        Item item = this.database.get(idGUID);
        if(item == null) {
            return Optional.empty();
        }
        return Optional.of(item);
    }
}
