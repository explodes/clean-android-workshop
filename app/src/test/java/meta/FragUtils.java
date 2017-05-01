/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

/**
 * Utility for creating a testable fragment that is in a known lifecycle state
 */
public final class FragUtils {

    private FragUtils() {
    }

    /**
     * Move the given fragment up to the {@link Fragment#onResume()} state
     *
     * @param frag a fragment which has not begun its lifecycle
     */
    @NonNull
    public static <F extends Fragment> ActivityController setFragmentResumed(@NonNull F frag) {
        return moveFragmentToLifecycleEvent(frag);
    }

    /**
     * Move the given fragment up to the {@link Fragment#onPause()} state
     *
     * @param frag a fragment which has not begun its lifecycle
     */
    @NonNull
    public static <F extends Fragment> ActivityController setFragmentPaused(@NonNull F frag) {
        ActivityController ctrl = moveFragmentToLifecycleEvent(frag);
        ctrl.pause();
        return ctrl;
    }

    /**
     * Move the given fragment up to the {@link Fragment#onStop()} state
     *
     * @param frag a fragment which has not begun its lifecycle
     */
    @NonNull
    public static <F extends Fragment> ActivityController setFragmentStopped(@NonNull F frag) {
        ActivityController ctrl = moveFragmentToLifecycleEvent(frag);
        ctrl.pause().stop();
        return ctrl;
    }

    /**
     * Move the given fragment up to the {@link Fragment#onDestroy()} state
     *
     * @param frag a fragment which has not begun its lifecycle
     */
    @NonNull
    public static <F extends Fragment> ActivityController setFragmentDestroyed(@NonNull F frag) {
        ActivityController ctrl = moveFragmentToLifecycleEvent(frag);
        ctrl.pause().stop().destroy();
        return ctrl;
    }

    @NonNull
    private static <F extends Fragment> ActivityController moveFragmentToLifecycleEvent(@NonNull F frag) {
        ActivityController controller = Robolectric.buildActivity(FakeActivity.class).create().start().postCreate(null).resume().visible();
        FakeActivity activity = (FakeActivity) controller.get();

        activity.getSupportFragmentManager()
                .beginTransaction().add(FakeActivity.VIEW_ID, frag, null).commit();

        activity.getSupportFragmentManager().executePendingTransactions();

        return controller;
    }

    private static class FakeActivity extends FragmentActivity {

        @IdRes
        private static final int VIEW_ID = 1;

        private FakeActivity() {
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            LinearLayout view = new LinearLayout(this);
            view.setId(VIEW_ID);
            this.setContentView(view);
        }
    }

}
