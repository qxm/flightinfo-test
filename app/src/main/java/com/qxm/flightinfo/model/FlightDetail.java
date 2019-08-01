package com.qxm.flightinfo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FlightDetail {
    @PrimaryKey
    public int id;
    public String flightNo;
    public String deptTime;
    public String arriveTime;
    public String schDeptTime;
    public String schArrTime;
    public String actDeptTime;
    public String actArrTime;
}
