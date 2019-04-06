package com.example.mainact;

import java.io.Serializable;

public class Lecture implements Serializable {

    private  String lecture_name, lecture_note;
    float lecture_avg;
    int registered;

    public Lecture(String lecture_name, String lecture_note) {
        this.lecture_name = lecture_name;
        this.lecture_note = lecture_note;
    }

    public Lecture(String lecture_name, String lecture_note, float lecture_avg, int registered) {
        this.lecture_name = lecture_name;
        this.lecture_note = lecture_note;
        this.lecture_avg = lecture_avg;
        this.registered = registered;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public String getLecture_note() {
        return lecture_note;
    }

    public void setLecture_note(String lecture_note) {
        this.lecture_note = lecture_note;
    }

    public float getLecture_avg() {
        return lecture_avg;
    }

    public void setLecture_avg(float lecture_avg) {
        this.lecture_avg = lecture_avg;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }
}
