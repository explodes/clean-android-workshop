package io.explod.quiz;

import android.support.annotation.NonNull;

import org.junit.Rule;
import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import meta.BaseRoboTest;
import meta.rx.ImmediateSchedulerRule;

import static org.junit.Assert.assertTrue;

public class RxTest extends BaseRoboTest {

    @Rule
    public ImmediateSchedulerRule mImmediateSchedulerRule = new ImmediateSchedulerRule();

    @Test
    public void rxShouldExecuteEverythingImmediately() {

        RxTest myTest = new RxTest();

        Disposable disposable = Observable.just("hello, world")
                .map(RxTest::reverseStatic)
                .map(this::reverseInstanceMethod)
                .map(myTest::reverseInstanceMethod)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Completed")
                );

        assertTrue(disposable.isDisposed());
    }

    @NonNull
    private static String reverseStatic(@NonNull String s) {
        String out = "";
        for (int index = s.length() - 1; index >= 0; index--) {
            out += s.charAt(index);
        }
        return out;
    }

    @NonNull
    private String reverseInstanceMethod(@NonNull String s) {
        reverseStatic(s);
    }

}

