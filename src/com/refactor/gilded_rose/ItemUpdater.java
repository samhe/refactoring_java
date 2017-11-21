package com.refactor.gilded_rose;

public class ItemUpdater {
    private Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public void updateItemQuality() {
        if ((!GildedRose.AGED_BRIE.equals(item.getName())) && !GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
            if (item.getQuality() > 0) {
                if (!GildedRose.SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if (GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
                    if (item.getSellIn() < 11) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }

                    if (item.getSellIn() < 6) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!GildedRose.SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0) {
            if (!GildedRose.AGED_BRIE.equals(item.getName())) {
                if (!GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT.equals(item.getName())) {
                    if (item.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                } else {
                    item.setQuality(item.getQuality() - item.getQuality());
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }
}