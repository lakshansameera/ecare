package com.example.shanindu.hearts.model;

import android.support.annotation.NonNull;

public class meals implements Comparable {
    private String sdate;
    private String edate;
    private String type;
    private String desc;


    public meals() {
    }

    public meals(String sdate, String edate, String type, String desc) {
        this.sdate = sdate;
        this.edate = edate;
        this.type = type;
        this.desc = desc;


    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}

