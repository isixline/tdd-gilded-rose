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

}
