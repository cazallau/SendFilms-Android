package com.cazallau.sendfilms.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * Created by gemabeltran on 23/1/17.
 */

public class FilmApi  {
    public static final  String BASE_URL="http://www.omdbapi.com/?s=";
    public static final  String METHOD_CURRENT_FILM ="&totalResults";

    public  interface FilmDonloadDataFinish {
        public void newFilmData(List<FilmResponse.Film> filmList);


    }

    private FilmDonloadDataFinish listener;

    public void setOnFilmDowloadDataFinish(FilmDonloadDataFinish listener) {
        this.listener = listener;
    }

    public void getCurrentFilms(Context context, String name){

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + name + METHOD_CURRENT_FILM;

        Log.d("URL", url);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //all ok

                Log.d("RESPONSE", response);
                if (response != "false") {
                    parseJSON(response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //tenemos un problema
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        queue.add(request);

    }
    public static void aaa(){

    }

    private void parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);
        FilmResponse filmResponse = gson.fromJson(reader, FilmResponse.class);
        Log.d("RESPONSE", filmResponse.toString());

        if (listener!=null & filmResponse.getFilms()!=null){
            listener.newFilmData(filmResponse.getFilms());
        }


    }



}
