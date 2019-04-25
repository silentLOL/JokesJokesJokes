package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.util.ApiServiceUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ApiServiceUtilTest {

    @Test
    public void retrieveJokeFromService() throws IOException {
        JokeApi api = ApiServiceUtil.getApiService();
        assertNotNull(api);
        String joke = api.tellJoke().execute().getData();
        assertTrue(!TextUtils.isEmpty(joke));
    }
}
