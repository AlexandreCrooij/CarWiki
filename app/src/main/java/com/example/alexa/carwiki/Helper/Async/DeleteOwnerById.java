package com.example.alexa.carwiki.Helper.Async;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.view.View;

import com.example.alexa.carwiki.Entities.AppDatabase;

import java.lang.ref.WeakReference;

/**
 * Created by alexa on 17.04.2018.
 */

public class DeleteOwnerById extends AsyncTask<Integer, Void, Void> {

    private final WeakReference<View> mView;

    public DeleteOwnerById(View view) {
        mView = new WeakReference<>(view);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        AppDatabase db = Room.databaseBuilder(mView.get().getContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().build();
        db.ownerDao().deleteOwnerWithId(integers[0]);
        return null;
    }
}