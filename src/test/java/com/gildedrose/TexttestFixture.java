package com.gildedrose;

/**
 * Test fixture for running the Gilded Rose application.
 */
public final class TexttestFixture {
    
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private TexttestFixture() {
        // Utility class - no instantiation needed
    }
    
    /**
     * Main method to run the Gilded Rose application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args) {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        System.out.println("OMGHAI!");

        for (int i = 0; i < 31; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
