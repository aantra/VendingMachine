package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private String id;
    private Integer slotCount;
    private List<Slot> slotList;
    private int slotMaxCapacity;

    public Inventory(String id, Integer slotCount, int slotMaxCapacity) {
        this.id = id;
        this.slotCount = slotCount;
        this.slotList = new ArrayList<Slot>();
        this.slotMaxCapacity = slotMaxCapacity;
    }

    public String getId() {
        return id;
    }

    public Integer getSlotCount() {
        return slotCount;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public int getSlotMaxCapacity() {
        return slotMaxCapacity;
    }

    public void setSlotCount(Integer slotCount) {
        this.slotCount = slotCount;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }

    public void setSlotMaxCapacity(int slotMaxCapacity) {
        this.slotMaxCapacity = slotMaxCapacity;
    }
}
