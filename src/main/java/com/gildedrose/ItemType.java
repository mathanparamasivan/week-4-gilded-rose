package com.gildedrose;

/**
 * Enumeration of item types in the Gilded Rose inventory system.
 * Each type has different quality update rules.
 */
public enum ItemType {
    
    /** Normal items that degrade in quality over time. */
    NORMAL,
    
    /** Aged Brie items that improve in quality over time. */
    AGED_BRIE,
    
    /** Backstage Passes that increase in quality as concert approaches. */
    BACKSTAGE_PASSES,
    
    /** Sulfuras items that never change in quality or sell-in date. */
    SULFURAS,
    
    /** Conjured items that degrade in quality twice as fast as normal items. */
    CONJURED
} 