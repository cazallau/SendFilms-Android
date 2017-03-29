package com.cazallau.sendfilms.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cazallau.sendfilms.R;
import com.cazallau.sendfilms.model.Film;
import com.squareup.picasso.Picasso;

public class FilmDetailsActivity extends AppCompatActivity {

    private TextView filmName;
    private ImageView filmPoster;
    private Button filmImdbIDButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        //quitar barra superroir
        getSupportActionBar().hide();
        setContentView(R.layout.activity_film_details);


        filmName = (TextView) findViewById(R.id.activity_film_details___filmName);
        filmPoster = (ImageView) findViewById(R.id.activity_film_details___filmPoster);
        filmImdbIDButton = (Button) findViewById(R.id.activity_film_details___film_imdb_button);

        Intent intent = getIntent();
        final Film film = (Film) intent.getSerializableExtra("FILM");

        filmName.setText(film.getName());
        Picasso.with(this).load(film.getPoster()).into(filmPoster);

        filmImdbIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.imdb.com/title/" + film.getImdbID());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
}
