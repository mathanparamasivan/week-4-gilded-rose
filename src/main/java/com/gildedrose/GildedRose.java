package com.gildedrose;

/**
 * Main class for the Gilded Rose inventory management system.
 * Handles updating item quality and sell-in dates based on business rules.
 */
public final class GildedRose {
    /** The array of items managed by this GildedRose instance. */
    private final Item[] items;

    /**
     * Constructs a new GildedRose instance with the specified items (varargs overload).
     *
     * @param items the items to manage
     */
    public GildedRose(final Item... items) {
        this.items = items.clone();
    }

    /**
     * Updates the quality and sell-in date for all items in the inventory.
     */
    public void updateQuality() {
        for (final Item item : items) {
            final QualityStrategy strategy = QualityStrategyFactory.createStrategy(item.getName());
            strategy.updateQuality(item);
            strategy.updateSellIn(item);
            strategy.updateQualityAfterSellIn(item);
        }
    }

    /**
     * Gets a copy of the array of items managed by this GildedRose instance.
     *
     * @return a copy of the array of items
     */
    public Item[] getItems() {
        return items.clone(); // Defensive copy
    }
}
