package com.gildedrose;

/**
 * Utility class containing quality bounds constants for items.
 */
public final class QualityBounds {
    
    /** The minimum quality value an item can have. */
    public static final int MIN_QUALITY = 0;
    
    /** The maximum quality value an item can have. */
    public static final int MAX_QUALITY = 50;
    
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private QualityBounds() {
        // Utility class - no instantiation needed
    }
    
    /**
     * Ensures the quality value is within the valid bounds.
     * 
     * @param quality the quality value to check
     * @return the quality value clamped to valid bounds
     */
    public static int ensureQualityBounds(final int quality) {
        return Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, quality));
    }
    
    public static boolean isQualityInBounds(int quality) {
        return quality >= MIN_QUALITY && quality <= MAX_QUALITY;
    }
} 