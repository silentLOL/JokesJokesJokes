package com.udacity.gradle.builditbigger.api;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    private static final String TAG = EndpointsAsyncTaskTest.class.getCanonicalName();

    @Test
    public void testIfJokeIsNotEmpty() throws ExecutionException, InterruptedException {
        String result = new EndpointsAsyncTask().execute(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void processJokeRequestResult(String joke) {
                Log.d(TAG, "received a joke: " + joke);
            }
        }).get();
        assertTrue(!TextUtils.isEmpty(result));
    }
}