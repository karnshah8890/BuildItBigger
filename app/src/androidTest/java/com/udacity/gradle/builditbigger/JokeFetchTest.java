package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 */

public class JokeFetchTest extends AndroidTestCase {

    private static final String LOG_TAG = "NonEmptyStringTest";


    public void testRetriveNonEmptyString() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("JokeFetchTest", "Running JokeFetchTest");
        String result = null;
        FetchJokesAsyncTask endpointsAsyncTask = new FetchJokesAsyncTask(null,getContext());
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
