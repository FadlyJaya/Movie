package com.example.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private ImageView imgPhoto;
        private TextView txtName, txtGenre, txtDurasi;

        ViewHolder(View view) {
            imgPhoto = view.findViewById(R.id.img_photo);
            txtName = view.findViewById(R.id.tv_name);
            txtGenre = view.findViewById(R.id.tv_genre);
            txtDurasi = view.findViewById(R.id.tv_durasi);
        }

        void bind(Movie movie) {
            imgPhoto.setImageResource(movie.getPhoto());
            txtName.setText(movie.getNama());
            txtGenre.setText(movie.getGenre());
            txtDurasi.setText(movie.getDurasi());
        }
    }

}