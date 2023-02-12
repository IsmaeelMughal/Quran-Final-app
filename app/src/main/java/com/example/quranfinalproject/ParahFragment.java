package com.example.quranfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ParahFragment extends Fragment {
    public String[] englishParahName = {"Alif Lam Meem",
            "Sayaqool ",
            "Tilkal Rusull",
            "Lan Tana Loo",
            "Wal Mohsanat",
            "La Yuhibbullah",
            "Wa Iza Samiu",
            "Wa Lau Annana",
            "Qalal Malao",
            "Wa A'lamu",
            "Yatazeroon ",
            "Wa Mamin Da'abat",
            "Wa Ma Ubrioo",
            "Rubama",
            "Subhanallazi",
            "Qal Alam",
            "Aqtarabo",
            "Qadd Aflaha",
            "Wa Qalallazina",
            "A'man Khalaq",
            "Utlu Ma Oohi",
            "Wa Manyaqnut",
            "Wa Mali",
            "Faman Azlam",
            "Elahe Yuruddo",
            "Ha'a Meem",
            "Qala Fama Khatbukum",
            "Qadd Sami Allah",
            "Tabarakallazi",
            "Amma Yatasa'aloon",
    };
    public String[] ParahName = {"الم ",
            "سیقول ",
            "تلک الرسل ",
            "لن تنالوالبر",
            "والمحصنت",
            "لایحب اللہ ",
            "واذاسمعوا",
            "ولواننا",
            "قال الملاء",
            "واعلموا",
            "یعتذرون ",
            "ومامن دآبۃ",
            "وماابرئ",
            "ربما",
            "سبحن الذی ",
            "قال الم ",
            "اقترب للناس",
            "قد افلح",
            "وقال الذین ",
            "امن خلق",
            "اتل مااوحی",
            "ومن یقنت ",
            "ومالی ",
            "فمن اظلم ",
            "الیہ یرد",
            "حم ",
            "قال فماخطبکم ",
            "قدسمع اللہ ",
            "تبارک الذی ",
            "عم یتسآءلون ",
    };


    List<ItemDetails> items = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public ParahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parah, container, false);

        items = getListOfParahObjs();

        recyclerView = view.findViewById(R.id.recyclerViewParah);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(items,"parah");
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ItemDetails> getListOfParahObjs() {
        List<ItemDetails> itemDetails = new ArrayList<>();
        for(int i = 0; i<englishParahName.length;i++)
        {
            itemDetails.add(new ItemDetails(i+1, ParahName[i], englishParahName[i]));
        }
        return itemDetails;
    }
}