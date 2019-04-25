package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.util.ApiServiceUtil;

import java.io.IOException;

import stefanirndorfer.at.jokingactivities.JokingActivity;

import static stefanirndorfer.at.jokingactivities.JokingActivity.JOKE_KEY;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask().execute(this);
    }

    private void navigateToJokeTellingActivity(String joke) {
        Intent intent = new Intent(this, JokingActivity.class);
        intent.putExtra(JOKE_KEY, joke);
        startActivity(intent);
    }

    public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
        private JokeApi myApiService = null;
        private Context context;


        @Override
        protected String doInBackground(Context... params) {
            if (myApiService == null) {  // Only do this once
                myApiService = ApiServiceUtil.getApiService();
            }
            context = params[0];

            try {
                return myApiService.tellJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }


        @Override
        protected void onPostExecute(String result) {
            navigateToJokeTellingActivity(result);
        }
    }


}