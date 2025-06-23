package com.gildedrose;

/**
 * Strategy for Conjured items which degrade in quality twice as fast as normal items.
 */
public final class ConjuredItemStrategy implements QualityStrategy {
    /** Default constructor. */
    public ConjuredItemStrategy() {}

    @Override
    public void updateQuality(final Item item) {
        if (item.getQuality() > QualityBounds.MIN_QUALITY) {
            item.setQuality(item.getQuality() - 2);
        }
    }

    @Override
    public void updateSellIn(final Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    @Override
    public void updateQualityAfterSellIn(final Item item) {
        if (item.getSellIn() < 0 && item.getQuality() > QualityBounds.MIN_QUALITY) {
            item.setQuality(item.getQuality() - 2);
        }
    }
} 