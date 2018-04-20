package com.example.alexa.carwiki.Helper.Async;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.view.View;

import com.example.alexa.carwiki.Entities.AppDatabase;
import com.example.alexa.carwiki.Entities.CarEntity;

import java.lang.ref.WeakReference;

/**
 * Created by alexa on 17.04.2018.
 */

public class UpdateCar extends AsyncTask<CarEntity, Void, Void> {

    // Weak references will still allow the Activity to be garbage-collected
    private final WeakReference<View> mView;

    public UpdateCar(View view) {
        mView = new WeakReference<>(view);
    }

    @Override
    protected Void doInBackground(CarEntity... carEntities) {
        AppDatabase db = Room.databaseBuilder(mView.get().getContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        db.carDao().updateCar(carEntities[0]);
        return null;
    }
}