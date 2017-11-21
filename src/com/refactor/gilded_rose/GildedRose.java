package com.refactor.gilded_rose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";

    private List<Item> items = null;
    private List<ItemUpdater> updaters = null;

    public GildedRose() {
        this.items = new ArrayList<Item>();
        this.updaters = new ArrayList<ItemUpdater>();
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.updaters.add(new ItemUpdater(item));
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void updateQuality() {
        for (int i = 0; i < updaters.size(); i++) {
            ItemUpdater updater = updaters.get(i);
            updater.updateItemQuality();
        }

    }

}