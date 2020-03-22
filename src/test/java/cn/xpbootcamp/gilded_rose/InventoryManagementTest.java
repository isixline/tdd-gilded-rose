package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class InventoryManagementTest {
    private InventoryManagement inventoryManagement = new InventoryManagement();

    @Test
    void should_return_same_when_spend_0_day(){
        int quality = 2;
        assertEquals(quality, inventoryManagement.calculateQualityAfterDays(anyString(), anyInt(), quality, anyInt(), 0));
    }

    @Test
    void should_change_double_rate_spend_more_than_sellIn(){
        int sellIn = 2;
        int quality = 10;
        int qualityRate = -1;
        int days = 5;
        int expectedQuality = 2;
        assertEquals(expectedQuality, inventoryManagement.calculateQualityAfterDays(anyString(), sellIn, quality, qualityRate, days));
    }

    @Test
    void should_more_when_qualityRate_is_positive() {
        int quality = 10;
        int qualityRate = 2;
        int days = 2;
        assertTrue(inventoryManagement.calculateQualityAfterDays(anyString(), anyInt(), quality, qualityRate, days) > quality);
    }

    @Test
    void should_same_when_qualityRate_is_0() {
        int quality = 10;
        int qualityRate = 0;
        assertTrue(inventoryManagement.calculateQualityAfterDays(anyString(), anyInt(), quality, qualityRate, anyInt()) == quality);
    }

    @Test
    void should_diff_qualityRate_when_type_is_BackstagePass_and_days_before_sellIn_10() {
        String type = "Backstage pass";
        int sellIn = 10;
        int quality = 10;
        int qualityRate = 1;
        int days = 6;
        int expectedQuality = 10 + 2 * 5 + 3 * 1;
        assertEquals(expectedQuality, inventoryManagement.calculateQualityAfterDays(type, sellIn, quality, qualityRate, days));
    }

    @Test
    void should_not_less_0() {
        int sellIn = 5;
        int quality = 5;
        int qualityRate = -1;
        int days = 10;
        int expectedQuality = 0;
        assertEquals(expectedQuality, inventoryManagement.calculateQualityAfterDays(anyString(), sellIn, quality, qualityRate, days));
    }

    @Test
    void should_not_more_50() {
        int sellIn = 5;
        int quality = 40;
        int qualityRate = 5;
        int days = 10;
        int expectedQuality = 50;
        assertEquals(expectedQuality, inventoryManagement.calculateQualityAfterDays(anyString(), sellIn, quality, qualityRate, days));
    }
}
