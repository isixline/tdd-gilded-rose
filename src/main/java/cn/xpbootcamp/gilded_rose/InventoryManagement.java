package cn.xpbootcamp.gilded_rose;

public class InventoryManagement {
    public int calculateQualityAfterDays(String type, int sellIn, int quality, int qualityRate,int days) {
        if (days <= 0){
            return quality;
        }

        if (type == "Backstage pass") {
            if (days > sellIn) {
                return 0;
            }
            if (sellIn <= 5) {
                return calculateQualityAfterDays("any", sellIn, quality, 3, days);
            }
            if (sellIn <= 10) {
                return calculateQualityAfterDays("any", sellIn, quality, 2, Math.min(sellIn - 5, days) ) + calculateQualityAfterDays("any", 5, quality, 3, days - (sellIn - 5)) - quality;
            }

            return calculateQualityAfterDays("any", sellIn - 10, quality, qualityRate, Math.min(sellIn - 10, days)) + calculateQualityAfterDays("Backstage pass", 10, quality, qualityRate, days - (sellIn - 10)) - quality;

        }

        int currentQuality = quality;

        if (sellIn >= days) {
            currentQuality += days * qualityRate;
        } else {
            currentQuality += sellIn * qualityRate + (days - sellIn) * 2 * qualityRate;
        }

        if (currentQuality < 0) {
            return 0;
        }
        if (currentQuality > 50) {
            return 50;
        }

        return currentQuality;
    }
}
