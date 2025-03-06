package com.gildedrose;

class GildedRose {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleItem(item);
        }
    }

    private void handleItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                handleAgedBrie(item);
                break;
            case SULFURAS:
                handleSufuras(item);
                break;
            case BACKSTAGE:
                handleBackstage(item);
                break;
            default:
                handleNormalItems(item);
                break;
        }
    }

    private void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void handleBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleSufuras(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void handleNormalItems(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;

        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
