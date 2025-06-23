package com.gildedrose;

/**
 * Strategy for Aged Brie items which improve in quality over time.
 */
public final class AgedBrieStrategy implements QualityStrategy {
    /** Default constructor. */
    public AgedBrieStrategy() {}

    @Override
    public void updateQuality(final Item item) {
        if (item.getQuality() < QualityBounds.MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    @Override
    public void updateSellIn(final Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    @Override
    public void updateQualityAfterSellIn(final Item item) {
        if (item.getSellIn() < 0 && item.getQuality() < QualityBounds.MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }
    }
} 