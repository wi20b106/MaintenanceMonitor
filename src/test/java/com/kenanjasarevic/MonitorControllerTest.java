package com.kenanjasarevic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class MonitorControllerTest {
    @Test // Method name must start with "test"
    public void test_calculateUptime_shouldBeCalculatedCorrectly() {
        // Arrange
        MonitorController controller = new MonitorController();
        // Act
        String actValue = controller.calculateUptime(99.95);
        // Assert
        Assertions.assertEquals("43178.40", actValue);
    }

    @Test
    public void test_getResponse_shouldGetResponse() {
        MonitorController controller = new MonitorController();
        Response actValue = controller.status();
        Assertions.assertEquals(200, actValue.getStatus());
    }

}

