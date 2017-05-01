package io.explod.quiz;

import android.app.Application;
import android.support.annotation.NonNull;

import io.explod.quiz.module.ObjectComponent;
import io.explod.quiz.module.ObjectGraph;

public abstract class App extends Application {

    private static App sInstance;

    public static App getApp() {
        return sInstance;
    }

    @NonNull
    protected abstract ObjectComponent createObjectComponent();

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        ObjectGraph.setObjectComponent(createObjectComponent());
    }

}
