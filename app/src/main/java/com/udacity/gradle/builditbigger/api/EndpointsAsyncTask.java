package com.udacity.gradle.builditbigger.api;

import android.os.AsyncTask;

import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.util.ApiServiceUtil;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.EndpointsAsyncTaskListener, Void, String> {
    private JokeApi myApiService = null;
    private EndpointsAsyncTaskListener listener;


    @Override
    protected String doInBackground(EndpointsAsyncTaskListener... params) {
        if (myApiService == null) {  // Only do this once
            myApiService = ApiServiceUtil.getApiService();
        }
        listener = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            // returns an empty String in fail case
            return "";
        }
    }


    @Override
    protected void onPostExecute(String result) {
        listener.processJokeRequestResult(result);
    }

    public interface EndpointsAsyncTaskListener {
        void processJokeRequestResult(String joke);
    }
}
