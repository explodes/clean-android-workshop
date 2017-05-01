package io.explod.quiz;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import javax.inject.Inject;

import io.explod.quiz.services.QuizService;
import meta.BaseRoboTest;
import meta.app.TestApp;
import meta.services.MockQuizService;

import static meta.module.TestObjectGraph.getTestInjector;
import static org.junit.Assert.assertTrue;

public class SampleTest extends BaseRoboTest {

    /**
     * @hide visible for injection
     */
    public static class InjectWithinTest {

        @Inject
        QuizService mQuizService;

        public InjectWithinTest() {
            getTestInjector().inject(this);
        }

    }

    @Test
    public void testsUseTestImplementations() {
        assertTrue(RuntimeEnvironment.application instanceof TestApp);

        assertTrue(new InjectWithinTest().mQuizService instanceof MockQuizService);
    }
}
