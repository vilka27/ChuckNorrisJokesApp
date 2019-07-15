package com.example.fork27.cnj.fragment;


import com.example.fork27.cnj.App;
import com.example.fork27.cnj.BasePresenter;
import com.example.fork27.cnj.room.ModelDao;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class JokePresenter extends BasePresenter<JokeFragment> {

    private ModelDao modelDao;

    @Override
    public void attachView(JokeFragment view) {
        super.attachView(view);
        modelDao = App.instance.getDatabase().modelDao();
    }

    public void loadJoke() {
        addDisposable(Observable.intervalRange(0, 5, 0, 0, TimeUnit.MILLISECONDS)
                .doOnSubscribe(disposable -> getView().showLoading(true))
                .flatMapSingle(count -> App.getApi().getJokeSingle()
                        .onErrorReturn(e -> modelDao.getRandomJoke((int) (modelDao.count() * Math.random()))))
                .flatMapSingle(joke -> Single.fromCallable(() -> {
                    modelDao.insert(joke);
                    return joke;
                }))
                .doOnTerminate(() -> getView().showLoading(false))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(joke -> getView().setJoke(joke),
                        throwable -> {
                            throwable.printStackTrace();
                            getView().showError();
                        }));
    }

}
