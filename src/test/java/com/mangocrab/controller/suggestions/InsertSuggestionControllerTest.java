package com.mangocrab.controller.suggestions;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InsertSuggestionControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/suggestions/InsertSuggestion");
        InsertSuggestionController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
