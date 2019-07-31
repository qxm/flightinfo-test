package com.qxm.flightinfo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.qxm.flightinfo.dao.UserDao;
import com.qxm.flightinfo.model.User;

@Database(entities = {User.class}, version = 2)
public abstract class FlightInfoDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
