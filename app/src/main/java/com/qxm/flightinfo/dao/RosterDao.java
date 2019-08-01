package com.qxm.flightinfo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.qxm.flightinfo.model.Roster;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface RosterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRoster(Roster... rosters);

    @Query("SELECT * FROM Roster")
    Flowable<List<Roster>> loadRosters();
}
