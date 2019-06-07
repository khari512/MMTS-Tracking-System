package com.mangocrab.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TrainTrackerDaoTest extends AppEngineTestCase {

    private TrainTrackerDao dao = new TrainTrackerDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
