package com.qxm.flightinfo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Roster {
    @PrimaryKey
    public int id;
    public String flightNo;
    public String deptTime;
    public String arriveTime;
    public String deptStatus;
    public String arrStatus;
    public String dutyType;

    public Roster(int id, String flightNo, String deptTime, String arriveTime, String deptStatus, String arrStatus, String dutyType) {
        this.id = id;
        this.flightNo = flightNo;
        this.deptTime = deptTime;
        this.arriveTime = arriveTime;
        this.deptStatus = deptStatus;
        this.arrStatus = arrStatus;
        this.dutyType = dutyType;
    }
}
