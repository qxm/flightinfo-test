package com.qxm.flightinfo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.qxm.flightinfo.model.FlightDetail;
import com.qxm.flightinfo.model.User;

import io.reactivex.Flowable;

@Dao
public interface FlightDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFlightDetail(FlightDetail... details);

    @Query("SELECT * FROM FlightDetail limit 1")
    Flowable<FlightDetail> loadFlightDetail();
}
