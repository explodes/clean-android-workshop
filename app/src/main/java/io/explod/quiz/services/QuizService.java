package io.explod.quiz.services;

import android.support.annotation.NonNull;

import io.reactivex.Single;

public interface QuizService {

    @NonNull
    Single<Question> getQuestion();

}
