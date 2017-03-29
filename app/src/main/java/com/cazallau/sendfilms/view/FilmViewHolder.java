package com.cazallau.sendfilms.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cazallau.sendfilms.model.Film;
import com.cazallau.sendfilms.R;
import com.cazallau.sendfilms.activities.FilmDetailsActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by gemabeltran on 23/1/17.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder {
    private Film film;

    private TextView filmName;
    private ImageView filmPoster;


    public FilmViewHolder(View row) {
        super(row);
        filmName = (TextView) row.findViewById(R.id.row_film___film_name);
        filmPoster = (ImageView) row.findViewById(R.id.row_film___poster);

        //Picasso.with(row.getContext()).load(film.getPoster()).into(filmPoster);


    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;


    }

    public void paint(Context context){
        filmName.setText(film.getName());
        Picasso.with(context).load(film.getPoster()).into(filmPoster);

    }
    public void aaa(Context context){
        Intent i = new Intent(context,FilmDetailsActivity.class);
        i.putExtra("FILM",film);
        context.startActivity(i);
    }
}
