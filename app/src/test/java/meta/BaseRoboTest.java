/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta;

import android.content.Context;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.Scheduler;

import io.explod.quiz.BuildConfig;
import meta.app.TestApp;

import static org.robolectric.Shadows.shadowOf;


/**
 * Base class for unit tests that use Android components.
 *
 * Created by evan on 4/13/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        application = TestApp.class
)
public abstract class BaseRoboTest {

    /**
     * Allows mocking to work with Robolectic and Dex
     */
    @Before
    public void setUpDexcache() {
        System.setProperty("dexmaker.dexcache", RuntimeEnvironment.application.getCacheDir().getPath());
    }

    /**
     * Wait for the Main looper to catch up on all of its pending events.
     *
     * Anything queued on the Main Looper will be executed.
     */
    protected static void waitForMainLooper() {
        Context context = RuntimeEnvironment.application;

        Scheduler scheduler = shadowOf(context.getMainLooper()).getScheduler();

        //noinspection StatementWithEmptyBody
        while (scheduler.advanceToLastPostedRunnable()) ;
    }

}
