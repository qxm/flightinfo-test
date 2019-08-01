package com.qxm.flightinfo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.qxm.flightinfo.dao.FlightDetailDao;
import com.qxm.flightinfo.dao.RosterDao;
import com.qxm.flightinfo.dao.UserDao;
import com.qxm.flightinfo.model.FlightDetail;
import com.qxm.flightinfo.model.Roster;
import com.qxm.flightinfo.model.User;

@Database(entities = {User.class, FlightDetail.class, Roster.class}, version = 2)
public abstract class FlightInfoDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FlightDetailDao flightDetailDao();
    public abstract RosterDao rosterDao();
}
