package com.qxm.flightinfo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notification {
    @PrimaryKey
    public int id;
    public String type;
    public String time;
    public String status;
}
