package com.example.mainact;


import java.io.Serializable;
import java.util.*;

public  class PassData implements Serializable {

    private  String name,surname;
    private  String phone, ssn;
    private int birth_year;
    private  byte[] pic_photo;

    public PassData() {
    }

    public PassData(String name, String surname, String phone, String ssn, int birth_year, byte[] pic_photo) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.ssn = ssn;
        this.birth_year = birth_year;
        this.pic_photo = pic_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth(int birth_year) {
        this.birth_year=birth_year;
    }

    public byte[] getPic_photo() {
        return pic_photo;
    }

    public void setPic_photo(byte[] pic_photo) {
        this.pic_photo = pic_photo;
    }
}
