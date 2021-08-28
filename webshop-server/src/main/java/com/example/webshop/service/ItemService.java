package com.example.webshop.service;

import com.example.webshop.model.*;
import com.example.webshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PictureService pictureService;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item findById(int item) {
        return itemRepository.findById(item);
    }

    public Item update(Item foundItem) {
        Set<Picture> pictures = new HashSet<>();
        for(Picture picture : foundItem.getPictures()) {
            Picture foundPicture = pictureService.getByPicture(picture.getPicture());
            if (foundPicture == null) {
                pictures.add(picture);
            } else {
                pictures.add(foundPicture);
            }
        }
        foundItem.setPictures(pictures);
        return itemRepository.save(foundItem);
    }

    public Item create(Item toEntity) {
        Item found = itemRepository.findByItemCodeOrName(toEntity.getItemCode(), toEntity.getName());
        if (found != null) {
            return null;
        }

        List<Picture> pictures = new ArrayList<>();
        for(Picture picture : toEntity.getPictures()) {
            Picture foundPicture = pictureService.getByPicture(picture.getPicture());
            if (foundPicture == null) {
                pictures.add(picture);
            } else {
                pictures.add(foundPicture);
            }
        }
        toEntity.setPictures((Set<Picture>) pictures);

        return itemRepository.save(toEntity);
    }

    public Item findBySaleId(int saleId) {
        return itemRepository.findBySaleId(saleId);
    }

    public List<Item> sort(SortParams sortParams, List<Item> items) {

        if (sortParams.getParam().equalsIgnoreCase("itemcode")) {
            return sortByItemCode(sortParams.getType(), items);
        } else if (sortParams.getParam().equalsIgnoreCase("name")) {
            return sortByName(sortParams.getType(), items);
        } else if (sortParams.getParam().equalsIgnoreCase("height")) {
            return sortByHeight(sortParams.getType(), items);
        } else if (sortParams.getParam().equalsIgnoreCase("price")) {
            return sortByPrice(sortParams.getType(), items);
        } else if (sortParams.getParam().equalsIgnoreCase("instock")) {
            return sortByInStock(sortParams.getType(), items);
        }
        return null;

    }

    private List<Item> sortByInStock(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparingInt(Item::getInStock));
        } else {
            items.sort((a,b)-> b.getInStock() - a.getInStock());
        }
        return items;
    }

    private List<Item> sortByPrice(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort((a,b)-> (int) (a.getPrice() - (b.getPrice())));
        } else {
            items.sort((a,b)->(int) (b.getPrice() - (a.getPrice())));
        }
        return items;
    }

    private List<Item> sortByHeight(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort((a,b)-> (int) (a.getHeight() - (b.getHeight())));
        } else {
            items.sort((a,b)->(int) (b.getHeight() - (a.getHeight())));
        }
        return items;
    }

    private List<Item> sortByName(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparing(Item::getName));
        } else {
            items.sort((a,b)->b.getName().compareTo(a.getName()));
        }
        return items;
    }

    private List<Item> sortByItemCode(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparing(Item::getItemCode));
        } else {
            items.sort((a,b)->b.getItemCode().compareTo(a.getItemCode()));
        }
        return items;
    }

    public List<Item> search(SearchParams searchParams) {
        return itemRepository.findByItemCodeOrNameContains(searchParams.getInput(), searchParams.getInput());
    }

    public List<Item> filter(FilterParams filterParams, List<Item> items) {

        for(Item item: items) {
            boolean filteredByHeightFrom = false;
            if (filterParams.getHeightFrom() != -1 && item.getHeight() < filterParams.getHeightFrom()) {
                filteredByHeightFrom = true;
            }

            boolean filteredByHeightTo = false;
            if (filterParams.getHeightTo() != -1 && item.getHeight() > filterParams.getHeightTo()) {
                filteredByHeightTo = true;
            }

            boolean filteredByPriceFrom = false;
            if (filterParams.getPriceFrom() != -1 && item.getPrice() < filterParams.getPriceFrom()) {
                filteredByPriceFrom = true;
            }

            boolean filteredByPriceTo = false;
            if (filterParams.getPriceTo() != -1 && item.getPrice() > filterParams.getPriceTo()) {
                filteredByPriceTo = true;
            }

            if (filteredByHeightFrom || filteredByHeightTo || filteredByPriceFrom || filteredByPriceTo) {
                items.remove(item);
            }
        }
        return items;
    }
}
