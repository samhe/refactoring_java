package com.refactor.gilded_rose;

public class ItemUpdaterImplBase extends ItemUpdater {
    //    y = a*x + b
    protected int a, b;

    public ItemUpdaterImplBase(Item item) {
        super(item);
    }

    protected void solveAB() {
        int updatedSellIn = item.getSellIn() - 1;
        if (updatedSellIn >= 0) {
            a = 1;
        } else {
            a = 2;
        }
        b = item.getQuality() - item.getSellIn() * a;
    }

    protected int getFilteredQuality(int updatedQuality) {
        return updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;
    }

    @Override
    public void updateItemQuality() {
        solveAB();
        int updatedSellIn = item.getSellIn() - 1;
        int updatedQuality = updatedSellIn * a + b;

        item.setSellIn(updatedSellIn);
        item.setQuality(getFilteredQuality(updatedQuality));
    }
}
