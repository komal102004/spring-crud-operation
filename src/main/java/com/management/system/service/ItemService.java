package com.management.system.service;

import com.management.system.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ItemService {
    private List<Item> itemList=new ArrayList<>();
    private Integer id=1;
    public Item createData(Item item) {
          item.setId(id++);
          itemList.add(item);
          return item;
    }

    public List<Item> getAllName() {
        return itemList;
    }


    public Item getNameById(Integer id) {
        for(Item item:itemList)
        {
            if(item.getId()==id)
            {
                return item;
            }
        }
        return null;
    }

    public String updateNameById(Integer id, Item updatedData) {
        for(Item item:itemList)
        {
            if(item.getId()==id)
            {
                item.setName(updatedData.getName());
                item.setAddress(updatedData.getAddress());
                item.setAge(updatedData.getAge());

            }
        }
        return "updated Data";
    }

    public String deleteItem(Integer id) {
        Iterator<Item> iterator=itemList.iterator();
        while(iterator.hasNext())
        {
            Item item=iterator.next();
            if(item.getId()==id)
            {
                iterator.remove();
                return "Item with ID "+id+" deleted sucess";
            }
        }
        return "Item with ID does not exist";
    }
}
