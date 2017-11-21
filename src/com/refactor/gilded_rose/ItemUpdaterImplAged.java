package com.refactor.gilded_rose;

public class ItemUpdaterImplAged extends ItemUpdaterImplBase {
    public ItemUpdaterImplAged(Item item) {
        super(item);
    }

    @Override
    protected void solveAB() {
        int updatedSellIn = item.getSellIn() -1;
        if (updatedSellIn >= 0) {
            a = -1;
        } else {
            a = -2;
        }
        b = item.getQuality() - item.getSellIn() * a;
    }
}
