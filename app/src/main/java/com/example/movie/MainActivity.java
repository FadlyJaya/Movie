package com.example.movie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TypedArray dataPhoto;
    private String[] dataName, dataGenre, dataDurasi, dataProduser, dataSutradara, dataPenulis, dataProduksi, dataSinopsis;

    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Button Clicked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("MOVIES", movies.get(position));

                startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataName = getResources().getStringArray(R.array.data_movie);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDurasi = getResources().getStringArray(R.array.data_durasi);
        dataProduser = getResources().getStringArray(R.array.data_produser);
        dataSutradara = getResources().getStringArray(R.array.data_sutradara);
        dataPenulis = getResources().getStringArray(R.array.data_penulis);
        dataProduksi = getResources().getStringArray(R.array.data_produksi);
        dataSinopsis = getResources().getStringArray(R.array.data_sinopsis);
    }


    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setNama(dataName[i]);
            movie.setGenre(dataGenre[i]);
            movie.setDurasi(dataDurasi[i]);
            movie.setProduser(dataProduser[i]);
            movie.setSutradara(dataSutradara[i]);
            movie.setPenulis(dataPenulis[i]);
            movie.setProduksi(dataProduksi[i]);
            movie.setSinopsis(dataSinopsis[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

}
