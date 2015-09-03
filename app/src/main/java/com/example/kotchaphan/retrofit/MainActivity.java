package com.example.kotchaphan.retrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new HttpAsyncTask().execute();
    }

    class HttpAsyncTask extends AsyncTask<Void, Void, Shot> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Shot shot) {
            Toast.makeText(getApplicationContext(), "Title : " + shot.getTitle() + " URL : " + shot.getUrl(), Toast.LENGTH_LONG).show();

            super.onPostExecute(shot);
        }

        @Override
        protected Shot doInBackground(Void... params) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://api.dribbble.com/")
                    .build();

            //SimpleRetrofit interface
            SimpleRetrofit retrofit = restAdapter.create(SimpleRetrofit.class);
            Shot shot = retrofit.getShot();
            return shot;
        }
    }
}
