package io.explod.quiz.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import io.explod.quiz.R;
import io.explod.quiz.services.QuizService;

import static io.explod.quiz.module.ObjectGraph.getInjector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    QuizService mQuizService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getInjector().inject(this);

        Log.d(TAG, "Quiz Service: " + mQuizService);
    }

}
