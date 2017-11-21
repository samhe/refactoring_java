package com.refactor.gilded_rose;

public class ItemUpdaterImplSulfuras extends ItemUpdaterImplBase {
    public ItemUpdaterImplSulfuras(Item item) {
        super(item);
    }

    @Override
    protected void solveAB() {
        a = 0;
        //NOTES: it should be 80 by default, should do quality validation ?
        b = item.getQuality();
    }

    @Override
    protected int getFilteredQuality(int updatedQuality) {
        return updatedQuality;
    }

}
