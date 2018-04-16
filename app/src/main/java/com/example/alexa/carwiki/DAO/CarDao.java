package com.example.alexa.carwiki.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexa.carwiki.Entities.CarEntity;

/**
 * Created by alexa on 15.04.2018.
 */

@Dao
public interface CarDao {
    @Insert
    public void insertCarEntity(CarEntity carEntity);

    @Update
    public void updateCar(CarEntity... cars);

    @Query("SELECT * FROM cars WHERE id_car = :id")
    public CarEntity getCarWithId(int id);

    @Query("SELECT * FROM cars")
    public CarEntity[] getAllCars();
}
