package com.github.gas.station;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AppTest
{
    @Test
    public void should_be_able_to_run_unit_test() throws Exception
    {
        // when
        App app = new App();

        // then
        assertThat(app.getTest(), is("test"));
    }
}
