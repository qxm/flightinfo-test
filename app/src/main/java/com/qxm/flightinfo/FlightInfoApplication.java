package com.qxm.flightinfo;

import android.app.Application;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qxm.flightinfo.database.FlightInfoDatabase;

public class FlightInfoApplication extends Application {
    private FlightInfoDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), FlightInfoDatabase.class, "flight_info.db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2 )
                .build();
    }

    public FlightInfoDatabase getAppDatabase() {
        return mAppDatabase;
    }


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("insert into  User values(1,'bob','Bob','123456','bob@bb.com')");
            android.util.Log.d("database","---------------------------");
            database.execSQL("insert into  FlightDetail values(1,'SQ238','09:35','15:25','09:35','15:25','09:46','15:05')");
            database.execSQL("insert into  Roster values(1,'SQ238','09:35','15:25','taken off','landed','standard')");
            database.execSQL("insert into  Roster values(2,'AM111','10:35','16:15','taken off','landed','standard')");
            database.execSQL("insert into  Roster values(3,'SK877','11:35','17:05','taken off','landed','standard')");
        }
    };
}
