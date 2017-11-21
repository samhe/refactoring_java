package com.refactor.gilded_rose;

public class ItemUpdaterImplBackstage extends ItemUpdaterImplBase {
    public ItemUpdaterImplBackstage(Item item) {
        super(item);
    }

    @Override
    protected void solveAB() {
        int updatedSellIn = item.getSellIn() - 1;
        if (updatedSellIn > 10) {
            a = -1;
            b = item.getQuality() - item.getSellIn() * a;
        }else if (updatedSellIn <= 10 & updatedSellIn > 3 ) {
            a = -2;
            b = item.getQuality() - item.getSellIn() * a;
        } else if (updatedSellIn >= 0 ) {
            a = -3;
            b = item.getQuality() - item.getSellIn() * a;
        } else {
            a = 0;
            b = 0;
        }
    }
}
