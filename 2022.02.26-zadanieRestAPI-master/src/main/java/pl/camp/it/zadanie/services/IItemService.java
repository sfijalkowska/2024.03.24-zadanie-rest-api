package pl.camp.it.zadanie.services;

import pl.camp.it.zadanie.model.Item;

import java.util.Optional;

public interface IItemService {
    void addItem(Item item);
    Optional<Item> getItem(String idGUID);
}
