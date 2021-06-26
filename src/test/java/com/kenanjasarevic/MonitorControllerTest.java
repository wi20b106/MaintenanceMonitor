package com.kenanjasarevic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class MonitorControllerTest {

    @Test
    public void test_getResponse_shouldGetResponse() {
        MonitorController controller = new MonitorController();
        Response actValue = controller.status();
        Assertions.assertEquals(200, actValue.getStatus());
    }

}

