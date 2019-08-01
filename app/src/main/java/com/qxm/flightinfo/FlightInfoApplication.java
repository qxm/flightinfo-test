package com.qxm.flightinfo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qxm.flightinfo.database.FlightInfoDatabase;

import java.util.concurrent.Executors;

public class FlightInfoApplication extends Application {
    private FlightInfoDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), FlightInfoDatabase.class, "flight_info.db")
                .allowMainThreadQueries()
                .addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull final SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        android.util.Log.d("database","---------------------------");
                        db.execSQL("insert into  FlightDetail values(1,'SQ238','09:35','15:25','09:35','15:25','09:46','15:05')");
                        db.execSQL("insert into  Roster values(1,'SQ238','09:35','15:25','taken off','landed','standard')");
                        db.execSQL("insert into  Roster values(2,'AM111','10:35','16:15','taken off','landed','standard')");
                        db.execSQL("insert into  Roster values(3,'SK877','11:35','17:05','taken off','landed','standard')");
                    }
                });
            }
        })
                .build();
    }

    public FlightInfoDatabase getAppDatabase() {
        return mAppDatabase;
    }



}
