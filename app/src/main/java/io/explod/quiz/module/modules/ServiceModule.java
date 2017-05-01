package io.explod.quiz.module.modules;


import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.explod.quiz.services.QuizService;
import io.explod.quiz.services.QuizServiceImpl;

@Module
public class ServiceModule {

    @Provides
    @NonNull
    @Singleton
    QuizService providesQuizService() {
        return new QuizServiceImpl();
    }

}
