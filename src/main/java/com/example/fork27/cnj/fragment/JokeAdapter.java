package com.example.fork27.cnj.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fork27.cnj.R;
import com.example.fork27.cnj.models.Joke;

import java.util.ArrayList;
import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private List<Joke> jokes = new ArrayList<>();

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new JokeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        holder.setJoke(jokes.get(position));

        if (onLoadMoreListener != null && holder.getAdapterPosition() == getItemCount() - 1) {

            onLoadMoreListener.onLoadMore();
        }

    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }


    public void addJoke(Joke joke) {
        this.jokes.add(joke);
        notifyDataSetChanged();
    }


    class JokeViewHolder extends RecyclerView.ViewHolder {

        Joke joke;
        TextView value;

        JokeViewHolder(View itemView) {
            super(itemView);

            value = itemView.findViewById(R.id.itemTextView);
        }

        void setJoke(Joke joke) {
            this.joke = joke;
            value.setText(joke.getValue());
        }
    }


    private OnLoadMoreListener onLoadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener listener) {
        this.onLoadMoreListener = listener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

}
