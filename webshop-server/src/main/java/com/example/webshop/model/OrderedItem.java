package com.example.webshop.model;

import com.example.webshop.model.enums.ProductType;

import javax.persistence.*;

@Entity
@Table(name = "orderedItems")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "itemCode")
    private String itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Column(name = "mask_name")
    private String maskName;

    @Column(name = "mask_item_code")
    private String maskItemCode;

    @Column(name = "mask_description")
    private String maskDescription;

    @Column(name = "number_of_pipes")
    private int numberOfPipes;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    public OrderedItem() {}

    public void init(double width, double height, ProductType productType) {
        this.width = width;
        this.height = height;
        this.type = productType;
    }

    private void init(double width, double height, int numberOfPipes, ProductType productType) {
        this.width = width;
        this.height = height;
        this.numberOfPipes = numberOfPipes;
        this.type = productType;
    }

    public void init(String name, String itemCode, String description, double price, int amount) {
        this.name = name;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public void init(String name, String itemCode, String description, double price, int amount, Mask foundMask) {
        this.name = name;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.maskName = foundMask.getName();
        this.maskItemCode = foundMask.getItemCode();
        this.maskDescription = foundMask.getDescription();
    }

    public OrderedItem(Product product, CartItem cartItem) {
        init(product.getName(), product.getItemCode(), product.getDescription(), cartItem.getPrice(), cartItem.getAmount());
        
        if (product instanceof Curtain) {
            init(cartItem.getWidth(), ((Curtain) product).getHeight(), ProductType.CURTAIN);
        } else if (product instanceof DecorativeItem) {
            init(((DecorativeItem) product).getWidth(), ((DecorativeItem) product).getHeight(), ProductType.DECORATIVE_ITEM);
        } else if (product instanceof Draper) {
            if (((Draper) product).getHeight() == 0) {
                init(((Draper) product).getWidth(), cartItem.getHeight(), ProductType.DRAPER);
            } else {
                init(cartItem.getWidth(), ((Draper) product).getHeight(), ProductType.DRAPER);
            }
        } else if (product instanceof FurnitureFabric) {
            init(cartItem.getWidth(), ((FurnitureFabric) product).getHeight(), ProductType.FURNITURE_FABRIC);
        } else if (product instanceof Wallpaper) {
            init(((Wallpaper) product).getWidth(), ((Wallpaper) product).getHeight(), ProductType.WALLPAPER);
        } else if (product instanceof Mechanism) {
            init(cartItem.getWidth(), cartItem.getHeight(), ((Mechanism) product).getNumberOfPipes(), ProductType.MECHANISM);
        } else {
            this.type = ProductType.MASK;
        }
    }

    public OrderedItem(Product product, CartItem cartItem, Mask foundMask) {
        init(product.getName(), product.getItemCode(), product.getDescription(), cartItem.getPrice(), cartItem.getAmount(), foundMask);

        if (product instanceof CurtainRod) {
            init(cartItem.getWidth(), 0, ((CurtainRod) product).getNumberOfPipes(), ProductType.CURTAIN_ROD);
        }
        else if (product instanceof RoloSystem) {
            init(cartItem.getWidth(), cartItem.getHeight(), ProductType.ROLO_SYSTEM);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaskName() {
        return maskName;
    }

    public void setMaskName(String maskName) {
        this.maskName = maskName;
    }

    public String getMaskItemCode() {
        return maskItemCode;
    }

    public void setMaskItemCode(String maskItemCode) {
        this.maskItemCode = maskItemCode;
    }

    public String getMaskDescription() {
        return maskDescription;
    }

    public void setMaskDescription(String maskDescription) {
        this.maskDescription = maskDescription;
    }

    public int getNumberOfPipes() {
        return numberOfPipes;
    }

    public void setNumberOfPipes(int numberOfPipes) {
        this.numberOfPipes = numberOfPipes;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
