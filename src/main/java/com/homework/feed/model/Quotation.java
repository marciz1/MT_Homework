package com.homework.feed.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quotation {
    private String instrument;
    private float bid;
    private float ask;
    private String time;

    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Quotation(String instrument, float bid, float ask, Date time) {
        this.instrument = instrument;
        this.bid = bid;
        this.ask = ask;
        this.time = dateFormat.format(time);
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Quotation{" +
            "instrument='" + instrument + '\'' +
            ", bid=" + bid +
            ", ask=" + ask +
            ", time='" + time + '\'' +
            '}';
    }
}
