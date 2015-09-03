package com.example.kotchaphan.retrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new HttpAsyncTask().execute();
    }

    class HttpAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... v) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://api.dribbble.com/")
                    .build();

            //SimpleRetrofit interface
            SimpleRetrofit retrofit = restAdapter.create(SimpleRetrofit.class);
            retrofit.getShotByIdWithCallback(21603, new Callback<Shot>() {
                @Override
                public void success(Shot shot, Response response) {
                    Toast.makeText(getApplicationContext(), "Title : " + shot.getTitle() + " URL : " + shot.getUrl(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
//            Shot shot = retrofit.getShotById(30000);
//            return shot;
            return null;
        }
    }
}
