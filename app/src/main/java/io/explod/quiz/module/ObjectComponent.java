package io.explod.quiz.module;

import javax.inject.Singleton;

import dagger.Component;
import io.explod.quiz.module.modules.AppModule;
import io.explod.quiz.module.modules.ServiceModule;

@Component(
        modules = {
                AppModule.class,
                ServiceModule.class,
        }
)
@Singleton
public interface ObjectComponent extends Injector {
}
