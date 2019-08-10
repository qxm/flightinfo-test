package com.qxm.flightinfo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.qxm.flightinfo.model.Notification;
import com.qxm.flightinfo.model.User;

import io.reactivex.Flowable;

@Dao
public interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNotifications(Notification... users);

    @Query("SELECT * FROM user limit 1")
    Flowable<User> loadUserProfile();
}
