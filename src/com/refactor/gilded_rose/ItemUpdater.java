package com.refactor.gilded_rose;

public abstract class ItemUpdater {
    protected Item item;
    //y = ax + b
    public ItemUpdater(Item item) {
        this.item = item;
    }

    public abstract void updateItemQuality();
}