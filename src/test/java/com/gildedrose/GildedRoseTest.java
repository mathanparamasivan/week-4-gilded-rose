package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose app;

    @BeforeEach
    void setUp() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };
        app = new GildedRose(items);
    }

    @Test
    void testNormalItemDegradation() {
        app.updateQuality();
        
        // +5 Dexterity Vest should degrade by 1
        assertEquals(19, app.getItems()[0].getQuality());
        assertEquals(9, app.getItems()[0].getSellIn());
        
        // Elixir of the Mongoose should degrade by 1
        assertEquals(6, app.getItems()[2].getQuality());
        assertEquals(4, app.getItems()[2].getSellIn());
    }

    @Test
    void testAgedBrieImprovement() {
        app.updateQuality();
        
        // Aged Brie should improve by 1
        assertEquals(1, app.getItems()[1].getQuality());
        assertEquals(1, app.getItems()[1].getSellIn());
    }

    @Test
    void testSulfurasNeverChanges() {
        app.updateQuality();
        
        // Sulfuras should never change
        assertEquals(80, app.getItems()[3].getQuality());
        assertEquals(0, app.getItems()[3].getSellIn());
        
        assertEquals(80, app.getItems()[4].getQuality());
        assertEquals(-1, app.getItems()[4].getSellIn());
    }

    @Test
    void testBackstagePassesQualityIncrease() {
        app.updateQuality();
        
        // Backstage passes with 15 days should increase by 1
        assertEquals(21, app.getItems()[5].getQuality());
        assertEquals(14, app.getItems()[5].getSellIn());
        
        // Backstage passes with 10 days should increase by 2
        assertEquals(50, app.getItems()[6].getQuality()); // Capped at 50
        assertEquals(9, app.getItems()[6].getSellIn());
        
        // Backstage passes with 5 days should increase by 3
        assertEquals(50, app.getItems()[7].getQuality()); // Capped at 50
        assertEquals(4, app.getItems()[7].getSellIn());
    }

    @Test
    void testConjuredItemDegradation() {
        app.updateQuality();
        
        // Conjured item should degrade by 2
        assertEquals(4, app.getItems()[8].getQuality());
        assertEquals(2, app.getItems()[8].getSellIn());
    }

    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Test Item", 0, 0) };
        GildedRose testApp = new GildedRose(items);
        
        testApp.updateQuality();
        
        assertEquals(0, testApp.getItems()[0].getQuality());
    }

    @Test
    void testQualityNeverExceedsFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose testApp = new GildedRose(items);
        
        testApp.updateQuality();
        
        assertEquals(50, testApp.getItems()[0].getQuality());
    }

    @Test
    void testBackstagePassesQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] { 
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) 
        };
        GildedRose testApp = new GildedRose(items);
        
        testApp.updateQuality();
        
        assertEquals(0, testApp.getItems()[0].getQuality());
        assertEquals(-1, testApp.getItems()[0].getSellIn());
    }
}
