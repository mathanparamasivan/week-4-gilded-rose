package com.gildedrose;

/**
 * Strategy for Sulfuras items which never change in quality or sell-in date.
 */
public final class SulfurasStrategy implements QualityStrategy {
    /** Default constructor. */
    public SulfurasStrategy() {}

    @Override
    public void updateQuality(final Item item) {
        // Sulfuras never changes quality
    }

    @Override
    public void updateSellIn(final Item item) {
        // Sulfuras never changes sellIn
    }

    @Override
    public void updateQualityAfterSellIn(final Item item) {
        // Sulfuras never changes quality
    }
} 