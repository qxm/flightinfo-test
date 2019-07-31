package com.qxm.flightinfo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;

    public String userId;
    public String userName;

    public String contactNumber;
    public String email;
}
