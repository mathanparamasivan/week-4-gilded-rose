package com.gildedrose;

/**
 * Factory class for creating quality strategies based on item names.
 */
public final class QualityStrategyFactory {
    /** Name for Aged Brie item. */
    private static final String AGED_BRIE = "Aged Brie";
    /** Name for Backstage Passes item. */
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    /** Name for Sulfuras item. */
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    /** Prefix for Conjured items. */
    private static final String CONJURED = "Conjured";
    
    /**
     * Private constructor to prevent instantiation of factory class.
     */
    private QualityStrategyFactory() {
        // Factory class - no instantiation needed
    }
    
    /**
     * Creates a quality strategy based on the item name.
     * 
     * @param itemName the name of the item
     * @return the appropriate quality strategy for the item
     */
    public static QualityStrategy createStrategy(final String itemName) {
        QualityStrategy strategy;
        if (AGED_BRIE.equals(itemName)) {
            strategy = new AgedBrieStrategy();
        } else if (BACKSTAGE.equals(itemName)) {
            strategy = new BackstagePassesStrategy();
        } else if (SULFURAS.equals(itemName)) {
            strategy = new SulfurasStrategy();
        } else if (itemName.startsWith(CONJURED)) {
            strategy = new ConjuredItemStrategy();
        } else {
            strategy = new NormalItemStrategy();
        }
        return strategy;
    }
} 