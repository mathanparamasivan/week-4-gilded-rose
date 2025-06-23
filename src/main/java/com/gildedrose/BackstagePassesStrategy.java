package com.gildedrose;

/**
 * Strategy for Backstage Passes which increase in quality as the concert approaches.
 */
public final class BackstagePassesStrategy implements QualityStrategy {
    /** 10-day bonus threshold. */
    private static final int BONUS_10_DAYS = 10;
    /** 5-day bonus threshold. */
    private static final int BONUS_5_DAYS = 5;

    /** Default constructor. */
    public BackstagePassesStrategy() {}

    @Override
    public void updateQuality(final Item item) {
        if (item.getQuality() < QualityBounds.MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
            
            if (item.getSellIn() <= BONUS_10_DAYS 
                    && item.getQuality() < QualityBounds.MAX_QUALITY) {
                item.setQuality(item.getQuality() + 1);
            }
            
            if (item.getSellIn() <= BONUS_5_DAYS 
                    && item.getQuality() < QualityBounds.MAX_QUALITY) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }

    @Override
    public void updateSellIn(final Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    @Override
    public void updateQualityAfterSellIn(final Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(QualityBounds.MIN_QUALITY);
        }
    }
} 