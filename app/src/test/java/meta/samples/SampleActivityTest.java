/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta.samples;


import org.junit.Ignore;
import org.junit.Test;
import org.robolectric.Robolectric;

import io.explod.quiz.ui.MainActivity;
import meta.BaseRoboTest;

import static org.junit.Assert.assertNotEquals;

/**
 * Example of how to test a fragment.
 *
 * Created by evan on 4/13/17.
 */
@Ignore
public class SampleActivityTest extends BaseRoboTest {

    @Test
    public void titleIsSet() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        waitForMainLooper(); // wait for everything to settle down

        assertNotEquals("", activity.getTitle().toString());
    }

}
