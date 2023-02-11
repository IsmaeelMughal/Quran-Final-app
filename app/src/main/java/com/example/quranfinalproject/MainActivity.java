package com.example.quranfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    private void loadJson()
    {
        try {
            InputStream inputStream = getAssets().open("QuranMetaData.json");
        }
        catch (Exception e)
        {
            Log.d("JSON", "ERROR: "+e);
        }
    }
}