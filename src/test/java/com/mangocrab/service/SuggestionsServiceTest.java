package com.mangocrab.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SuggestionsServiceTest extends AppEngineTestCase {

    private SuggestionsService service = new SuggestionsService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
