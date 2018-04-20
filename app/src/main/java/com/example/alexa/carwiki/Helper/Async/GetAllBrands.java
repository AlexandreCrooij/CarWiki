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

public class GetAllBrands extends AsyncTask<Void, Void, List<CarBrandEntity>> {

    private final WeakReference<View> mView;

    public GetAllBrands(View view) {
        mView = new WeakReference<>(view);
    }

    @Override
    protected List<CarBrandEntity> doInBackground(Void... voids) {
        AppDatabase db = Room.databaseBuilder(mView.get().getContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().build();
        return db.carBrandDao().getAllBrands();
    }
}
