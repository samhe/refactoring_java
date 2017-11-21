package com.refactor.gilded_rose;

public class ItemUpdaterImplBackstage extends ItemUpdater {
    public ItemUpdaterImplBackstage(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        int updatedSellIn = item.getSellIn() - 1;
        int updatedQuality, a, b;
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
        updatedQuality = updatedSellIn * a + b;
        updatedQuality = updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;

        item.setSellIn(updatedSellIn);
        item.setQuality(updatedQuality);
    }
}
