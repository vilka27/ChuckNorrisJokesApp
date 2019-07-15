package com.example.fork27.cnj;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fork27.cnj.fragment.JokeFragment;
import com.example.fork27.cnj.room.AppDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, JokeFragment.newInstance())
                .commit();
    }


}
