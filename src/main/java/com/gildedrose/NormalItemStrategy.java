package com.gildedrose;

/**
 * Strategy for normal items which degrade in quality over time.
 */
public final class NormalItemStrategy implements QualityStrategy {
    /** Default constructor. */
    public NormalItemStrategy() {}

    @Override
    public void updateQuality(final Item item) {
        if (item.getQuality() > QualityBounds.MIN_QUALITY) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    @Override
    public void updateSellIn(final Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    @Override
    public void updateQualityAfterSellIn(final Item item) {
        if (item.getSellIn() < 0 && item.getQuality() > QualityBounds.MIN_QUALITY) {
            item.setQuality(item.getQuality() - 1);
        }
    }
} 