package com.example.quranfinalproject;

public class ItemDetails {
    int number;
    String arabicName;
    String englishName;

    public ItemDetails(int number, String arabicName, String englishName) {
        this.number = number;
        this.arabicName = arabicName;
        this.englishName = englishName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
}
