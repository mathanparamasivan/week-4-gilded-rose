package com.gildedrose;

/**
 * Strategy interface for updating item quality and sell-in values.
 * Different item types implement different strategies for quality management.
 */
public interface QualityStrategy {
    
    /**
     * Updates the quality of an item based on the strategy rules.
     * 
     * @param item the item to update
     */
    void updateQuality(Item item);
    
    /**
     * Updates the sell-in date of an item.
     * 
     * @param item the item to update
     */
    void updateSellIn(Item item);
    
    /**
     * Updates the quality of an item after the sell-in date has passed.
     * 
     * @param item the item to update
     */
    void updateQualityAfterSellIn(Item item);
} 