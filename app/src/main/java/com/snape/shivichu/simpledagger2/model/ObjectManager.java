package com.snape.shivichu.simpledagger2.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;


public class ObjectManager {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public ObjectManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void save(String key, Object o){
        sharedPreferences.edit()
                .putString(key, gson.toJson(o))
                .apply();
    }

    public <T> T get(String key, Class<T> type){
        String json = sharedPreferences.getString(key, null);
        if(json == null){
            return null;
        }

        return gson.fromJson(json, type);
    }
}
