/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta.app;

import android.support.annotation.NonNull;

import io.explod.quiz.App;

import meta.module.DaggerTestObjectComponent;
import meta.module.TestObjectComponent;

/**
 * Contains test/mocked implementations of key application components.
 * Primarily, this will override external services.
 *
 * Created by evan on 4/13/17.
 */
public class TestApp extends App {

    @NonNull
    @Override
    protected TestObjectComponent createObjectComponent() {
        return DaggerTestObjectComponent.builder()
                .build();
    }
}
