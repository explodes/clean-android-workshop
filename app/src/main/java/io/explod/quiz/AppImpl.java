package io.explod.quiz;

import android.support.annotation.NonNull;

import io.explod.quiz.module.DaggerObjectComponent;
import io.explod.quiz.module.ObjectComponent;
import io.explod.quiz.module.modules.AppModule;

public class AppImpl extends App {

    @NonNull
    @Override
    protected ObjectComponent createObjectComponent() {
        return DaggerObjectComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
