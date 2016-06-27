package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.karn.shah.backend.myJokeApi.MyJokeApi;
import com.proteus.androidjokepresenterlibrary.JokePresenterActivity;

import java.io.IOException;

/**
 * Created by karn.shah on 27-06-2016.
 */
public class FetchJokesAsyncTask extends AsyncTask<Void, Void, String> {
    protected Context context;
    protected ProgressBar progressBar;
    private MyJokeApi myApiService = null;

    public FetchJokesAsyncTask(ProgressBar progressBar,Context context) {
        this.context=context;
        this.progressBar=progressBar;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().toPrettyString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (progressBar!=null){
            progressBar.setVisibility(View.GONE);
        }
        Intent intent = new Intent(context, JokePresenterActivity.class);
        intent.putExtra(JokePresenterActivity.JOKE_INTENT, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
