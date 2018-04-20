package com.example.alexa.carwiki.Helper.Async;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.view.View;

import com.example.alexa.carwiki.Entities.AppDatabase;
import com.example.alexa.carwiki.Entities.CarBrandEntity;
import com.example.alexa.carwiki.Entities.OwnerEntity;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by alexa on 17.04.2018.
 */


public class GetBrandById extends AsyncTask<Integer, Void, CarBrandEntity> {

    private final WeakReference<View> mView;

    public GetBrandById(View view) {
        mView = new WeakReference<>(view);
    }


    @Override
    protected CarBrandEntity doInBackground(Integer... integers) {
        AppDatabase db = Room.databaseBuilder(mView.get().getContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().build();
        return db.carBrandDao().getBrandbyId(integers[0]);
    }
}