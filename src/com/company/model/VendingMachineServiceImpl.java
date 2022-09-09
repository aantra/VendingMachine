package com.company.model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VendingMachineServiceImpl implements VendingMachineService{
    public VendingMachineServiceImpl() {
        createSlot();
    }

    // TODO:
    @Override
    public void getInventory() {
        final List<Slot> slotList = inventory.getSlotList();
            for(Slot s: slotList){
                if(s.getProduct()!=null){
                    System.out.println(s);
                }
            }
    }

    @Override
    public void restockProducts(Action action, Integer slotId, Product product, Integer quantity) {
        if(Action.DELETE == action){
            deleteProductFromSlot(slotId,product,quantity);
        }
        else if(Action.ADD == action){
            addProductToSlot(slotId,product,quantity);
        }
        else{
            System.out.println("not allowed action");
        }
    }

    @Override
    public int selectProducts(List<Item> items) {
        int totalPrice = 0;
        for(Item item:items){
            final Product product = (Product) item.getProduct();
            final Integer quantity = (Integer) item.getQuantity();
            totalPrice+=product.getPrice()*quantity;
        }
        return totalPrice;
    }

    @Override
    public void buyProducts(List<Item> items) {

        for(Item item:items){
            final Product product = (Product) item.getProduct();
            final Integer quantity = (Integer) item.getQuantity();

            for(Slot slot: inventory.getSlotList()){
                final Product slotProduct = slot.getProduct();
//                if(product.getId() == slotProduct.getId()){
//                    while (quantity!=0)
////                    final int capacity = slot.getCurrentCccupiedCapacity();
////                    if(capacity >= quantity){
////                        slot.setCurrentCccupiedCapacity(capacity-quantity);
////                    }
//
//                }
            }
        }
    }

    // TODO : validate if slot could be added in inventory

    boolean validateSlotAdd(Slot slot){
        return true;
    }
    public void createSlot(){
        Slot slot = new Slot(1);
        validateSlotAdd(slot);
        inventory.getSlotList().add(slot);
        inventory.getSlotList().add(new Slot(2));
        inventory.getSlotList().add(new Slot(3));
        inventory.getSlotList().add(new Slot(4));
        inventory.getSlotList().add(new Slot(5));
    }

    private Product createProduct(final String productName,final Integer price){
        Product product =new Product(Integer.parseInt(UUID.fromString(productName).toString()), productName,price);
        return product;
    }

    // TODO:
    private void addProductToSlot(int slotId, Product product, int quantity){
        final List<Slot> collect = inventory.getSlotList().stream().filter(s -> s.getId() == slotId).collect(Collectors.toList());
        if(collect!=null){
            if(collect.get(0).getCurrentCccupiedCapacity() == 0){
                collect.get(0).setProduct(product);
                collect.get(0).setCurrentCccupiedCapacity(quantity);
            }
            else {
                if (product.getId() == collect.get(0).getProduct().getId()) {
                    int currentQuantity = collect.get(0).getCurrentCccupiedCapacity();
                    if (currentQuantity + quantity < inventory.getSlotMaxCapacity()) {
                        collect.get(0).setCurrentCccupiedCapacity(currentQuantity + quantity);
                        collect.get(0).setProduct(product);
                    } else {
                        System.out.println("not allowed to add product in slot " + slotId);
                    }
                }
                else {
                    System.out.println("product not allowed to add in slot id due to mismatch of product from slot preferred product "+slotId);
                }
            }


        }
        else {
            System.out.println("invalid slot id provided");
        }
    }

    private void deleteProductFromSlot(int slotId, Product product, int quantity){
        final List<Slot> collect = inventory.getSlotList().stream().filter(s -> s.getId() == slotId).collect(Collectors.toList());
        if(collect!=null){
            if(product.getId() == collect.get(0).getProduct().getId()){
                int currentQuantity = collect.get(0).getCurrentCccupiedCapacity();
                if(currentQuantity>=quantity){
                    collect.get(0).setCurrentCccupiedCapacity(currentQuantity-quantity);

                }
               else {
                    System.out.println("not allowed to delete product from slot "+slotId);
                }
            }
            else {
                System.out.println("product not found in slotid "+slotId);

            }

        }
    }
}
