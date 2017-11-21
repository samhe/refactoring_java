package com.refactor.gilded_rose;

public class ItemUpdaterImplSulfuras extends ItemUpdater {
    public ItemUpdaterImplSulfuras(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        int updatedSellIn = item.getSellIn() - 1;
        int updatedQuality, a = 0, b = item.getQuality();

        updatedQuality = updatedSellIn * a + b;

        item.setSellIn(updatedSellIn);
        item.setQuality(updatedQuality);
    }
}
