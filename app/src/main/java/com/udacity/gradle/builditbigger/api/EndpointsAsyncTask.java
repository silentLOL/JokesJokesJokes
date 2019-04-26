package com.udacity.gradle.builditbigger.api;

import android.content.Context;
import android.os.AsyncTask;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.util.ApiServiceUtil;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<MainActivity, Void, String> {
    private JokeApi myApiService = null;
    private MainActivity mainActivity;


    @Override
    protected String doInBackground(MainActivity... params) {
        if (myApiService == null) {  // Only do this once
            myApiService = ApiServiceUtil.getApiService();
        }
        context = params[0].getApplicationContext();

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
        navigateToJokeTellingActivity(result);
    }
}
