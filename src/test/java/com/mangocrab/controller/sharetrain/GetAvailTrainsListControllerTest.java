package com.mangocrab.controller.sharetrain;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetAvailTrainsListControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/sharetrain/GetAvailTrainsList");
        GetAvailTrainsListController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/sharetrain/GetAvailTrainsList.jsp"));
    }
}
