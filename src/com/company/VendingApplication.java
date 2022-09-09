package com.company;

import com.company.model.Action;
import com.company.model.Item;
import com.company.model.Product;
import com.company.model.VendingMachineServiceImpl;

import java.util.Arrays;
import java.util.List;

public class VendingApplication {

    public static void main(String[] args) {
	// write your code here

        VendingMachineServiceImpl vendingMachineService = new VendingMachineServiceImpl();
        vendingMachineService.createSlot();
        Product p1 =  getProduct(11, "Colgate");
        Product p2 = getProduct(31, "Brush");
        Product p3 = getProduct(81, "Soap");
        vendingMachineService.restockProducts(Action.ADD,
                1,p1,4);
        vendingMachineService.restockProducts(Action.ADD, 2, p2, 4);
        vendingMachineService.restockProducts(Action.ADD, 3, p3, 4);

        vendingMachineService.getInventory();
        System.out.println("After deleting some products");
        vendingMachineService.restockProducts(Action.DELETE, 3, getProduct(81, "Soap"), 1);
        vendingMachineService.getInventory();

        System.out.println("Select some products");
        List<Item> itemList = Arrays.asList(new Item[]{new Item<>(p1, 3), new Item<>(p2, 3), new Item<>(p3, 3)});
        System.out.println(vendingMachineService.selectProducts(itemList));


    }

    private static Product getProduct(int i, String productName) {
        return new Product(i, productName, 10);
    }
}
