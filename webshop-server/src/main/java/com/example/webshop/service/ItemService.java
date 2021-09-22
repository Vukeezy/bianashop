package com.example.webshop.service;

import com.example.webshop.exceptions.*;
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
        Item found = itemRepository.findById(item);
        if (found == null) {
            throw new ItemNotFoundException();
        }
        return found;
    }

    public Item update(Item foundItem) {

        manageItemPictures(foundItem);

        try {
            return itemRepository.save(foundItem);
        } catch (Exception e) {
            throw new UpdateItemFailException();
        }
    }

    public Item create(Item toEntity) {
        Item found = itemRepository.findByItemCodeOrName(toEntity.getItemCode(), toEntity.getName());
        if (found != null) {
            if (found.getItemCode().equalsIgnoreCase(toEntity.getItemCode()) &&
                    !found.getName().equalsIgnoreCase(toEntity.getName())) {
                throw new ItemUniqueCodeException();
            } else if (!found.getItemCode().equalsIgnoreCase(toEntity.getItemCode()) &&
                    found.getName().equalsIgnoreCase(toEntity.getName())) {
                throw new ItemUniqueNameException();
            } else {
                throw new ItemUniqueCodeAndNameException();
            }
        }

        manageItemPictures(toEntity);

        try {
            return itemRepository.save(toEntity);
        } catch (Exception e) {
            throw new CreateItemFailException();
        }
    }

    private void manageItemPictures(Item item) {

        Set<Picture> pictures = new HashSet<>();
        for(Picture picture : item.getPictures()) {
            Picture foundPicture = pictureService.getByPicture(picture.getPicture());
            if (foundPicture == null) {
                pictures.add(picture);
            } else {
                pictures.add(foundPicture);
            }
        }
        Picture mainPic = pictureService.getByPicture(item.getMainPicture().getPicture());
        if (mainPic != null) {
            item.setMainPicture(mainPic);
        }

        item.setPictures(pictures);
    }

    public Item findBySaleId(int saleId) {
        Item found = itemRepository.findBySaleId(saleId);
        if (found == null) {
            throw new ItemNotFoundException();
        }
        return found;
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
        throw new NoSortParamsException();
    }

    private List<Item> sortByInStock(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparingInt(Item::getInStock));
        } else if (type.equalsIgnoreCase("desc")) {
            items.sort((a,b)-> b.getInStock() - a.getInStock());
        } else {
            throw new InvalidSortTypeException();
        }
        return items;
    }

    private List<Item> sortByPrice(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort((a,b)-> (int) (a.getPrice() - (b.getPrice())));
        } else if (type.equalsIgnoreCase("desc")) {
            items.sort((a,b)->(int) (b.getPrice() - (a.getPrice())));
        } else {
            throw new InvalidSortTypeException();
        }
        return items;
    }

    private List<Item> sortByHeight(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort((a,b)-> (int) (a.getHeight() - (b.getHeight())));
        } else if (type.equalsIgnoreCase("desc")) {
            items.sort((a,b)->(int) (b.getHeight() - (a.getHeight())));
        } else {
            throw new InvalidSortTypeException();
        }
        return items;
    }

    private List<Item> sortByName(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparing(Item::getName));
        } else if (type.equalsIgnoreCase("desc")) {
            items.sort((a,b)->b.getName().compareTo(a.getName()));
        } else {
            throw new InvalidSortTypeException();
        }
        return items;
    }

    private List<Item> sortByItemCode(String type, List<Item> items) {
        if (type.equalsIgnoreCase("asc")) {
            items.sort(Comparator.comparing(Item::getItemCode));
        } else if (type.equalsIgnoreCase("desc")) {
            items.sort((a,b)->b.getItemCode().compareTo(a.getItemCode()));
        } else {
            throw new InvalidSortTypeException();
        }
        return items;
    }

    public List<Item> search(SearchParams searchParams) {
        try {
            return itemRepository.findByItemCodeOrNameContainsIgnoreCase(searchParams.getInput(), searchParams.getInput());
        } catch (Exception e) {
            throw new SearchingWentWrongException();
        }
    }

    public List<Item> filter(FilterParams filterParams, List<Item> items) {
        List<Item> result = new ArrayList<>();
        for(Item item:items) {

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

            if (!(filteredByHeightFrom || filteredByHeightTo || filteredByPriceFrom || filteredByPriceTo)) {
                result.add(item);
            }
        }

        return result;
    }
}
