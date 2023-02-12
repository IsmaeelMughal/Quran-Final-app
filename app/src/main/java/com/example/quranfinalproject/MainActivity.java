package com.example.quranfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //loadJson();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_surah:
                        System.out.println("SURAH------------");
                        break;

                    case R.id.nav_parah:
                        System.out.println("PARAH+++++++++++++");
                        break;

                    case R.id.nav_git:
                        System.out.println("GITHUB");
                        break;

                    case R.id.nav_exit:
                        System.out.println("EXIT");
                        break;
                }
                return true;
            }
        });
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