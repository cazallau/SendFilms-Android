package com.cazallau.sendfilms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cazallau.sendfilms.R;
import com.cazallau.sendfilms.model.Film;
import com.cazallau.sendfilms.view.FilmViewHolder;

import java.util.List;

/**
 * Created by gemabeltran on 23/1/17.
 */

public class FilmListAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private List<Film> filmList;
    private LayoutInflater inflater;


    public FilmListAdapter(Context context, List<Film> filmList) {
        inflater = LayoutInflater.from(context);
        this.filmList = filmList;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_film, parent, false);
        FilmViewHolder row = new FilmViewHolder(view);

        return row;
    }

    @Override
    public void onBindViewHolder(final FilmViewHolder holder, final int position) {
        Film film = filmList.get(position);
        holder.setFilm(film);
        holder.paint(holder.itemView.getContext());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("POSITION","posicion"+position);
                holder.aaa(holder.itemView.getContext());
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }


}
