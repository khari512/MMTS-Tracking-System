package com.mangocrab.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TrainTrackerServiceTest extends AppEngineTestCase {

    private TrainTrackerService service = new TrainTrackerService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
