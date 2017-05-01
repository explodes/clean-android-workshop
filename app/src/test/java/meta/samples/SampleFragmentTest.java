/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta.samples;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.junit.Ignore;
import org.junit.Test;

import meta.BaseRoboTest;

import static meta.FragUtils.setFragmentResumed;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example of how to test a fragment.
 *
 * Created by evan on 4/13/17.
 */
@Ignore
public class SampleFragmentTest extends BaseRoboTest {

    public static class Frag extends Fragment {

        @NonNull
        public static Frag newInstance() {
            return new Frag();
        }

        @IdRes
        private static final int VIEW_ID = 0x100;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView view = new TextView(inflater.getContext());

            view.setId(VIEW_ID);
            view.setText("Hello, world!");

            return view;
        }
    }

    @Test
    public void onCreateViewHasText() throws Exception {
        // build
        Frag frag = Frag.newInstance();
        setFragmentResumed(frag);

        // execute
        TextView text = (TextView) frag.getView();

        // verify
        assertNotNull(text);
        assertEquals("Hello, world!", text.getText().toString());
    }

}
