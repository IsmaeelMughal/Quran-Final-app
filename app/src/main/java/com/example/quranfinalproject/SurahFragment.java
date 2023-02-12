package com.example.quranfinalproject;

import android.content.ClipData;
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

public class SurahFragment extends Fragment {

    List<ItemDetails> items = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public SurahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surah, container, false);

        items = getListOfSurahsObjs();

        recyclerView = view.findViewById(R.id.recyclerViewSurah);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(items,"surah");
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ItemDetails> getListOfSurahsObjs() {
        List<ItemDetails> itemDetails = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
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
                if(itemDetails.size() == 0)
                {
                    itemDetails.add(new ItemDetails(jsonObject.getInt("surah_number"),
                            jsonObject.getString("surah_name"),
                            jsonObject.getString("englishName")));
                    list.add(jsonObject.getInt("surah_number"));
                }
                else
                {
                    if (!list.contains(jsonObject.getInt("surah_number")))
                    {
                        itemDetails.add(new ItemDetails(jsonObject.getInt("surah_number"),
                                jsonObject.getString("surah_name"),
                                jsonObject.getString("englishName")));
                        list.add(jsonObject.getInt("surah_number"));
                    }
                }
            }
        }
        catch (Exception e)
        {
            Log.d("JSON", "ERROR: "+e);
        }
        return itemDetails;
    }
}