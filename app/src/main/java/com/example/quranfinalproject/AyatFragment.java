package com.example.quranfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AyatFragment extends Fragment {

    List<String> items = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public AyatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ayat, container, false);

        Bundle bundle = this.getArguments();
        String type = bundle.getString("type");
        if(Objects.equals(type, "surah"))
        {
            items = findAyatsInSurah(bundle.getInt("number"));
        }
        else if (Objects.equals(type, "parah"))
        {
            items = findAyatsInParah(bundle.getInt("number"));
        }


        recyclerView = view.findViewById(R.id.recyclerViewAyat);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AyatRVAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<String> findAyatsInParah(int number) {
        List<String> ayats = new ArrayList<>();
        try {
            // load JSON
            InputStream inputStream = getContext().getAssets().open("QuranMetaData.json");
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
                if(jsonObject.getInt("juz") == number)
                {
                    ayats.add(jsonObject.getString("text"));
                }
            }
        }
        catch (Exception e)
        {
            Log.d("JSON", "ERROR: "+e);
        }
        return ayats;
    }

    private List<String> findAyatsInSurah(int number) {
        List<String> ayats = new ArrayList<>();
        try {
            // load JSON
            InputStream inputStream = getContext().getAssets().open("QuranMetaData.json");
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
                if(jsonObject.getInt("surah_number") == number)
                {
                    ayats.add(jsonObject.getString("text"));
                }
            }
        }
        catch (Exception e)
        {
            Log.d("JSON", "ERROR: "+e);
        }
        return ayats;
    }
}