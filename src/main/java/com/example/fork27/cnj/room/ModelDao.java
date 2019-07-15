package com.example.fork27.cnj.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.fork27.cnj.models.Joke;

import java.util.List;

@Dao
public interface ModelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Joke joke);

    @Delete
    void delete(Joke joke);

    @Query("SELECT * FROM Joke")
    List<Joke> getAllJokes();

    @Query("SELECT * FROM Joke WHERE id = :id")
    Joke getJokeById(int id);

    @Query("SELECT COUNT(*) FROM Joke")
    int count();

    @Query("SELECT * FROM Joke LIMIT :count-:offset , :count")
    List<Joke> getLatestJokes(int count, int offset);

    @Query("SELECT * FROM Joke LIMIT :pos, :pos+1 ")
    Joke getRandomJoke(int pos);

}
