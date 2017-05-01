package meta.module.modules;


import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.explod.quiz.services.QuizService;
import meta.services.MockQuizService;

@Module
public class TestServiceModule {

    @Provides
    @NonNull
    @Singleton
    QuizService providesQuizService() {
        return new MockQuizService();
    }

}
