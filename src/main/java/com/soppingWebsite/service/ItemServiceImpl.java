package com.soppingWebsite.service;

import com.soppingWebsite.model.Item;
import com.soppingWebsite.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createItem(Item item) {
        if(item.getItemId() != null) {
            throw new IllegalArgumentException("Invalid id.");
        }
        itemRepository.createItem(item);
    }

    @Override
    public void updateItem(Item item) {
        if(itemRepository.getItemById(item.getItemId()) == null) {
            throw new IllegalArgumentException("Item does not exist.");
        }
        itemRepository.updateItem(item);
    }

    @Override
    public void deleteItemById(Long itemId) {
        if(itemRepository.getItemById(itemId) == null) {
            throw new IllegalArgumentException("Item does not exist.");
        }
        itemRepository.deleteItemById(itemId);
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.getItemById(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public List<Item> getItemsContainingSearchText(String searchText) {
        return itemRepository.getItemsContainingSearchText(searchText);
    }
}
