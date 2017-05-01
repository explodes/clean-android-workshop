package meta.module;

import android.support.annotation.NonNull;

import static io.explod.quiz.module.ObjectGraph.getInjector;

public class TestObjectGraph {

	@NonNull
	public static TestInjector getTestInjector() {
		return (TestInjector) getInjector();
	}

}
