package com.refactor.gilded_rose;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GildedRoseTest {

    private GildedRose gildedRose;
    @Before
    public void initGildedRose() {
        this.gildedRose = new GildedRose();
    }
    //q = s*a + b
    private int getDexterityVestQualityBySellIn(Item item) {
        int updatedSellIn = item.getSellIn() - 1;
        int updatedQuality, a, b;
        if (updatedSellIn >= 0) {
            a = 1;
        } else {
            a = 2;
        }
        b = item.getQuality() - item.getSellIn() * a;
        updatedQuality = updatedSellIn * a + b;
        return updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;
    }

    @Test
    public void should_return_correct_result_for_dexterity_vest() throws Exception {
        gildedRose.addItem(new Item(GildedRose.DEXTERITY_VEST, 30, 40));
        gildedRose.addItem(new Item(GildedRose.DEXTERITY_VEST, 50, 50));
        gildedRose.addItem(new Item(GildedRose.DEXTERITY_VEST, 70, 50));
        for (int i = 0; i < 60; i++) {
            List<Item> items = gildedRose.getItems();
            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                int expectedQuality = getDexterityVestQualityBySellIn(item);
                GildedRose.updateItemQuality(item);
                assertEquals(expectedQuality, item.getQuality());
            }
        }
    }

    //q = s*a + b
    private int getAgedBrieQualityBySellIn(Item item) {
        int updatedSellIn = item.getSellIn() -1;
        int updatedQuality, a = -1, b;

        if (updatedSellIn >= 0) {
            a = -1;
        } else {
            a = -2;
        }
        b = item.getQuality() - item.getSellIn() * a;
        updatedQuality = updatedSellIn * a + b;
        return updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;
    }

    @Test
    public void should_return_correct_result_for_aged_brie() throws Exception {
        gildedRose.addItem(new Item(GildedRose.AGED_BRIE, 30, 1));
        gildedRose.addItem(new Item(GildedRose.AGED_BRIE, 60, 0));
        gildedRose.addItem(new Item(GildedRose.AGED_BRIE, 10, 20));
        for (int i = 0; i < 60; i++) {
            List<Item> items = gildedRose.getItems();
            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                int expectedQuality = getAgedBrieQualityBySellIn(item);
                GildedRose.updateItemQuality(item);
                assertEquals(expectedQuality, item.getQuality());
            }
        }
    }


    //q = s*a + b
    private int getSulfurasQualityBySellIn(Item item) {
        int updatedSellIn = item.getSellIn()  -1 ;
        int updatedQuality, a = 0, b = item.getQuality();

        updatedQuality = updatedSellIn * a + b;
        return updatedQuality;
    }

    @Test
    public void should_return_correct_result_for_sulfuras() throws Exception {
        gildedRose.addItem(new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 30, 80));
        for (int i = 0; i < 60; i++) {
            List<Item> items = gildedRose.getItems();
            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                int expectedQuality = getSulfurasQualityBySellIn(item);
                GildedRose.updateItemQuality(item);
                assertEquals(expectedQuality, item.getQuality());
            }
        }
    }


    //q = s*a + b
    private int getBackstageQualityBySellIn(Item item) {
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
        return updatedQuality > 0 ? (updatedQuality <= 50 ? updatedQuality : 50) : 0;
    }

    @Test
    public void should_return_correct_result_for_backtage() throws Exception {
        gildedRose.addItem(new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 30, 50));
        gildedRose.addItem(new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 60, 1));
        for (int i = 0; i < 60; i++) {
            List<Item> items = gildedRose.getItems();
            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                int expectedQuality = getBackstageQualityBySellIn(item);
                GildedRose.updateItemQuality(item);
                assertEquals(expectedQuality, item.getQuality());
            }
        }
    }
}