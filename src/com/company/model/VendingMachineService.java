package com.company.model;

import java.util.List;

public interface VendingMachineService {
    Inventory inventory = new Inventory("123", 5, 10);

    void getInventory();

    void restockProducts(Action action, Integer slotId, Product product, Integer quantity);

    int selectProducts(List<Item> items);

    void buyProducts(List<Item> items);
}
