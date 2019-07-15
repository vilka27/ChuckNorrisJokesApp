package com.example.fork27.cnj.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.fork27.cnj.models.Joke;

@Database(entities = {Joke.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ModelDao modelDao();
}
