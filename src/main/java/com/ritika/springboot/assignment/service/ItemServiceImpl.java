package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.dao.ItemsRepository;
import com.ritika.springboot.assignment.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemsRepository itemsRepository;

    @Autowired
    public ItemServiceImpl(ItemsRepository theItemsRepository){
        itemsRepository = theItemsRepository;
    }

    @Transactional
    @Override
    public List<Item> findAll() {
        return itemsRepository.findAll();
    }

    @Transactional
    @Override
    public Item findById(int theId) {
        Optional<Item> result = itemsRepository.findById(theId);

        Item theItem = null;
        if(result.isPresent()){
            theItem = result.get();
        }else{
            throw new RuntimeException("Did not find item id - " + theId);
        }

        return theItem;
    }

    @Override
    public void save(Item theItem) {
        itemsRepository.save(theItem);
    }

    @Override
    public void deleteById(int theId) {
        itemsRepository.deleteById(theId);
    }
}
