package pl.camp.it.zadanie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.zadanie.model.Item;
import pl.camp.it.zadanie.services.IItemService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    IItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addItem(@RequestBody Item item) {
        this.itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/{idGUID}", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(@PathVariable String idGUID) {
        Optional<Item> itemBox = this.itemService.getItem(idGUID);
        if(itemBox.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(itemBox.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
