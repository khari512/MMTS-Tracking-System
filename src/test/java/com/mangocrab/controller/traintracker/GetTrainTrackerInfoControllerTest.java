package com.mangocrab.controller.traintracker;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetTrainTrackerInfoControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/traintracker/GetTrainTrackerInfo");
        GetTrainTrackerInfoController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/traintracker/GetTrainTrackerInfo.jsp"));
    }
}
