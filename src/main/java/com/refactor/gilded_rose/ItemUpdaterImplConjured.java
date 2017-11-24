package com.refactor.gilded_rose;

public class ItemUpdaterImplConjured extends ItemUpdaterImplBase {
    public ItemUpdaterImplConjured(Item item) {
        super(item);
    }

    @Override
    protected void solveAB() {
        int updatedSellIn = item.getSellIn() - 1;
        if (updatedSellIn >= 0) {
            a = 2;
        } else {
            a = 4;
        }
        b = item.getQuality() - item.getSellIn() * a;
    }
}
