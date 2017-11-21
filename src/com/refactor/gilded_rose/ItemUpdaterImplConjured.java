package com.refactor.gilded_rose;

public class ItemUpdaterImplConjured extends ItemUpdater {
    public ItemUpdaterImplConjured(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        int updatedSellIn = item.getSellIn() - 1;
        int updatedQuality, a, b;
        if (updatedSellIn >= 0) {
            a = 2;
        } else {
            a = 4;
        }
        b = item.getQuality() - item.getSellIn() * a;
        updatedQuality = updatedSellIn * a + b;
        updatedQuality = updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;

        item.setSellIn(updatedSellIn);
        item.setQuality(updatedQuality);
    }
}
