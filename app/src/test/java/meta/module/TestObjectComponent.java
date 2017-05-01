package meta.module;

import javax.inject.Singleton;

import dagger.Component;
import io.explod.quiz.module.ObjectComponent;
import meta.module.modules.TestServiceModule;

@Component(
        modules = {
                TestServiceModule.class,
        }
)
@Singleton
public interface TestObjectComponent extends ObjectComponent, TestInjector {
}
