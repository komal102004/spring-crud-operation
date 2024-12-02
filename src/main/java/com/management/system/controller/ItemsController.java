package com.management.system.controller;

import com.management.system.model.Item;
import com.management.system.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/add")
    public Item createData(@RequestBody Item item)
    {
        return itemService.createData(item);
    }

   @GetMapping
    public List<Item> getAllItems()
   {
       return itemService.getAllName();
   }
  @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id)
  {
      return itemService.getNameById(id);
  }
    @PutMapping("/{id}")
    public String updateItem(@PathVariable Integer id, @RequestBody Item updatedName)
    {
        return itemService.updateNameById(id,updatedName);
    }
  @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id)
  {
      return itemService.deleteItem(id);

  }
}
