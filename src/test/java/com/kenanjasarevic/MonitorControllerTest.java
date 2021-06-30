package com.kenanjasarevic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MonitorControllerTest {

    @Test
    public void test_status_shouldGetResponse() {
        MonitorController controller = new MonitorController();
        Response actValue = controller.status();
        Assertions.assertEquals(200, actValue.getStatus());
    }

    @Test
    public void test_status_shouldFindFile() {
        MonitorController controller = new MonitorController();
        File tempFile = new File("data/MonitorStatus.txt");
        Assertions.assertEquals(true, tempFile.exists());
    }

    @Test
    public void test_postStatus_shouldModifyFile() {
        String text = "";
        MonitorController controller = new MonitorController();
        File tempFile = new File("data/MonitorStatus.txt");
        String actValue = controller.postStatus("running");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile))) {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("running", text);
    }

    @Test
    public void test_postStatus_shouldSetRunningStatus() {
        MonitorController controller = new MonitorController();
        String actValue = controller.postStatus("running");
        Assertions.assertEquals("Status updated to running\n", actValue);
    }

    @Test
    public void test_postStatus_shouldSetDownStatus() {
        MonitorController controller = new MonitorController();
        String actValue = controller.postStatus("down");
        Assertions.assertEquals("Status updated to down\n", actValue);
    }

    @Test
    public void test_postStatus_shouldResetStatus() {
        MonitorController controller = new MonitorController();
        String actValue = controller.postStatus(true);
        Assertions.assertEquals("Monitor reset completed\n", actValue);
    }

    @Test
    public void test_postStatus_shouldNotResetStatus() {
        MonitorController controller = new MonitorController();
        String actValue = controller.postStatus(false);
        Assertions.assertEquals("Monitor not reset\n", actValue);
    }
}

