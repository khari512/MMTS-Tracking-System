package com.mangocrab.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TimingsTest extends AppEngineTestCase {

    private Timings model = new Timings();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
