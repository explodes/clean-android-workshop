package io.explod.quiz.module.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.explod.quiz.App;

@Module
public class AppModule {

	private App mApp;

	public AppModule(@NonNull App app) {
		mApp = app;
	}

	@Provides
	@NonNull
	@Singleton
	App providesApp() {
		return mApp;
	}

}
