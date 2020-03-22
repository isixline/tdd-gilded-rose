package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class InventoryManagementTest {
    @Test
    void should_return_same_when_spend_0_day(){
        InventoryManagement inventoryManagement = new InventoryManagement();
        int quality = 2;
        assertEquals(quality, inventoryManagement.calculateQualityAfterDays(anyString(), anyInt(), quality, anyInt(), 0));
    }

}
