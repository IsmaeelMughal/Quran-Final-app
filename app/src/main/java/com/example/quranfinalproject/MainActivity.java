package com.example.quranfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadJson();
    }

    private void loadJson()
    {
        try {
            // load JSON
            InputStream inputStream = getAssets().open("QuranMetaData.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            // fetch JSON
            String json;
            int max;
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            for (int i = 0; i < max; i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String t = jsonObject.getString("text");
                Log.d("JSON","TEXT:"+t);
            }
        }
        catch (Exception e)
        {
            Log.d("JSON", "ERROR: "+e);
        }
    }
}