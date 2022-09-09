package com.company.model;

public class Slot {
    private int id;
    private Product product;
    private int currentCccupiedCapacity;

    public Slot(int id, Product product, int currentCccupiedCapacity) {
        this.id = id;
        this.product = product;
        this.currentCccupiedCapacity = currentCccupiedCapacity;
    }

    public Slot(int id) {
        this.id = id;
        this.currentCccupiedCapacity = 0;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getCurrentCccupiedCapacity() {
        return currentCccupiedCapacity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCurrentCccupiedCapacity(int currentCccupiedCapacity) {
        this.currentCccupiedCapacity = currentCccupiedCapacity;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", product=" + product.getName() +
                ", productPrice=" + product.getPrice() +
                ", availableQuantity=" + currentCccupiedCapacity +
                '}';
    }
}
