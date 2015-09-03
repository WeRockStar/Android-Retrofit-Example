package com.example.kotchaphan.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.dribbble.com/")
                .build();

        //SimpleRetrofit interface
        SimpleRetrofit retrofit = restAdapter.create(SimpleRetrofit.class);
        Shot shot = retrofit.getShot();

        Toast.makeText(getApplicationContext(), "Title : " + shot.getTitle() + " URL : " + shot.getUrl(), Toast.LENGTH_SHORT).show();

        new HttpAsyncTask().execute();
    }
}
