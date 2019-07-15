package com.example.fork27.cnj.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fork27.cnj.R;
import com.example.fork27.cnj.models.Joke;
import com.example.fork27.cnj.room.ModelDao;

public class JokeFragment extends Fragment {

    private ProgressBar prbar;

    private JokePresenter presenter;
    private JokeAdapter jokeadapter = new JokeAdapter();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    public static JokeFragment newInstance() {

        Bundle args = new Bundle();

        JokeFragment fragment = new JokeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joke, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        jokeadapter.setOnLoadMoreListener(() -> {
            presenter.loadJoke();

        });
        recyclerView.setAdapter(jokeadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        prbar = view.findViewById(R.id.progressBar);

        presenter = new JokePresenter();
        presenter.attachView(this);
        presenter.loadJoke();

    }

    void showLoading(boolean show) {
        getActivity().runOnUiThread(() -> {
            prbar.setVisibility(show ? View.VISIBLE : View.GONE);
        });
    }

    void setJoke(Joke joke) {
        jokeadapter.addJoke(joke);

    }

    void showError() {
        Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
