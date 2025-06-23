package com.gildedrose;

/**
 * Represents an item in the Gilded Rose inventory system.
 * Each item has a name, sell-in date, and quality value.
 *
 * @SuppressWarnings("PMD.ShortClassName")
 */
@SuppressWarnings("PMD.ShortClassName")
public final class Item {
    /** The name of the item. */
    private String name;
    /** The number of days to sell the item. */
    private int sellIn;
    /** The quality value of the item. */
    private int quality;

    /**
     * Constructs a new Item with the specified properties.
     *
     * @param name the name of the item
     * @param sellIn the number of days to sell the item
     * @param quality the quality value of the item
     */
    public Item(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * Gets the name of the item.
     *
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the new item name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the sell-in date of the item.
     *
     * @return the sell-in date
     */
    public int getSellIn() {
        return sellIn;
    }

    /**
     * Sets the sell-in date of the item.
     *
     * @param sellIn the new sell-in date
     */
    public void setSellIn(final int sellIn) {
        this.sellIn = sellIn;
    }

    /**
     * Gets the quality value of the item.
     *
     * @return the quality value
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Sets the quality value of the item.
     *
     * @param quality the new quality value
     */
    public void setQuality(final int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
