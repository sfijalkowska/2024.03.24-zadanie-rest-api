package pl.camp.it.zadanie.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.camp.it.zadanie.configuration.AppConfiguration;
import pl.camp.it.zadanie.model.Item;
import pl.camp.it.zadanie.services.IItemService;

import java.util.Map;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class ItemServiceTest {

    @Autowired
    IItemService itemService;

    @Autowired
    Map<String, Item> database;

    @Before
    public void prepareData() {
        this.database.clear();
    }

    @Test
    public void addItemTest() throws InterruptedException {
        Item item = new Item("id1", "name1");

        this.itemService.addItem(item);

        for(int i = 0; i < 100; i++) {
            Thread.sleep(50);
            Item itemFromDataBase = this.database.get("id1");
            if(itemFromDataBase != null) {
                return;
            }
        }

        Assert.fail();
    }

    @Test
    public void getNotExistingItemTest() {
        String id = "id1";

        Optional<Item> itemBox = this.itemService.getItem(id);

        if(itemBox.isPresent()) {
           Assert.fail();
        }
    }

    @Test
    public void getItemTest() {
        String id = "id1";
        Item item = new Item(id, "name1");
        this.database.put(id, item);

        Optional<Item> itemBox = this.itemService.getItem(id);

        if(!itemBox.isPresent()) {
            Assert.fail();
        }
    }
}
