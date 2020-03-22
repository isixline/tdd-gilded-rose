package cn.xpbootcamp.gilded_rose;

public class InventoryManagement {
    public int calculateQualityAfterDays(String type, int sellIn, int quality, int qualityRate,int days) {
        int currentQuality = quality;
        if (sellIn >= days) {
            currentQuality += days * qualityRate;
        } else {
            currentQuality += sellIn * qualityRate + (days - sellIn) * 2 * qualityRate;
        }


        return currentQuality;
    }
}
