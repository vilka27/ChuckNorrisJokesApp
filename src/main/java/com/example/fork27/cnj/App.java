package com.example.fork27.cnj;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.fork27.cnj.room.AppDatabase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application{

    private static ChuckNorrisApi chuckNorrisApi;
    public static App instance;
    private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(this,
                AppDatabase.class, "jokes")
                .build();
    }

    public static ChuckNorrisApi getApi() {
        if (chuckNorrisApi == null) {
            chuckNorrisApi = new Retrofit.Builder()
                    .baseUrl("https://api.chucknorris.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(ChuckNorrisApi.class);
        }
        return chuckNorrisApi;
    }

    public AppDatabase getDatabase() {
        return db;
    }
}
