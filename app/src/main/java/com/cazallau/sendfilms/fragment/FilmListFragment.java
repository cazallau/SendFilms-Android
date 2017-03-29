package com.cazallau.sendfilms.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.cazallau.sendfilms.model.Film;
import com.cazallau.sendfilms.managers.FilmApi;
import com.cazallau.sendfilms.adapter.FilmListAdapter;
import com.cazallau.sendfilms.managers.FilmResponse;
import com.cazallau.sendfilms.R;
import com.cazallau.sendfilms.activities.FilmDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmListFragment extends Fragment {

    private RecyclerView recyclerView;

    private EditText send;
    private ImageButton button;

    public FilmListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_film_list___film_list);
        send = (EditText) view.findViewById(R.id.fragment_film_list___send);
        button = (ImageButton) view.findViewById(R.id.fragment_film_list___button);
        senfFilms("new");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    senfFilms(send.getText().toString());
                //Esconder el teclado
                InputMethodManager imm =
                        (InputMethodManager) v.getContext().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
        });






        return view;
    }

    public void senfFilms(String search){
        final List<Film> filmLista = new ArrayList<>();

                FilmApi film = new FilmApi();
                film.getCurrentFilms(getContext(),search);
                film.setOnFilmDowloadDataFinish(new FilmApi.FilmDonloadDataFinish() {
                    @Override
                    public void newFilmData(List<FilmResponse.Film> filmList ) {
                        filmLista.clear();
                        for (int i = 0; i < filmList.size() ; i++) {
                            Film film = new Film(filmList.get(i).getTitle(), filmList.get(i).getPoster(), filmList.get(i).getImdbID());
                            filmLista.add(film);
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }

                });



                FilmListAdapter adapter = new FilmListAdapter(getContext(), filmLista);
                recyclerView.setAdapter(adapter);



    }

    public void aaa(int position){

        Intent i = new Intent(getContext(),FilmDetailsActivity.class);

        startActivity(i);

    }


}
